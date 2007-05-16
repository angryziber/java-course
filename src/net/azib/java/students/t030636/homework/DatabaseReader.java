package net.azib.java.students.t030636.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * DatabaseReader
 *
 * @author Martin
 */
public class DatabaseReader {
	
	protected Connection connection = null;
	
	public void initializeConnection(String url, String user, String password) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url, user, password);
	}
	
	public void displayCompetitionsFromDatabase () throws SQLException {
		String query = "SELECT c.description, c.id, c.date FROM competitions AS c";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
//		resultSet.first();
		System.out.println("Competitions currently in database:");
		System.out.println("ID \tDescription");
		while (resultSet.next()) {
			System.out.println( resultSet.getString("id") + "\t" + resultSet.getString("description")+ " on " + resultSet.getDate("date")); 
		}
		System.out.println("\nTo use multiple ID's separate them with commas\nInsert the competition ID(s) to use:");
		resultSet.close();
		statement.close();	
	}
	
	public String[] readDatabase(String competition) throws SQLException {
		String query = "SELECT a.name, a.dob, a.country_code, r.race_100m, r.long_jump, r.shot_put, r.high_jump, r.race_400m, r.hurdles_110m, r.discus_throw, r.pole_vault, r.javelin_throw, r.race_1500m"
			+ " FROM results AS r INNER JOIN athletes AS a ON a.id = r.athlete_id "
			+ " WHERE r.competition_id = " + competition.replace(",", " OR ");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
//		resultSet.first();
		String [] list = extractData(resultSet); 
		resultSet.close();
		statement.close();
		return list;
	}
	
	public String[] extractData(ResultSet rs) throws SQLException {
		List<String> list = new ArrayList<String>();
		String line = null;
		while (rs.next()) {
			line = "\"" + rs.getString("name")+ "\"," + rs.getDate("dob").toString().replace("-", ".")+","+rs.getString("country_code");
			for (int i = 4 ; i<=13; i++){
				
				Float f  = rs.getFloat(i);
				String toAdd = null;
				
				if ((i==8 || i== 13) && f > 60){
					int minutes = 0;
					while (f > 60) {
						f = f - 60;
						minutes ++;
					}
					f*=100;
					f = (float) Math.round(f)/100;
					if (f < 10) {
						toAdd = minutes +":0"+ f.toString();						
					}
					else {
						toAdd = minutes +":"+ f.toString();						
					}
				}
				else {
					String end = f.toString();
					if (end.substring(end.indexOf(".")).length()== 2)
						toAdd = end + "0";
					else
						toAdd = end ;
				}
					
			line = line + "," + toAdd;
			}
			list.add(line);
		}
		
		String [] data = new String[list.size()];
		int i = 0;
		for (String s : list){
			data [i] = s;
			i++;
		}
		return data;
	}

}
