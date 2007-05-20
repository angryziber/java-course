package net.azib.java.students.t030636.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseReader class
 *
 * @version 1.0
 * @author Martin
 * 
 */
public class DatabaseReader {
	
	protected Connection connection = null;
	/**
	 * initializeConnection method initializes a connection to a MySql server.
	 * @param url - URL for the database
	 * @param user - database user
	 * @param password - database password for the user
	 * @version 1.0
	 * @author Martin
	 * 
	 */
	public void initializeConnection(String url, String user, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url, user, password);
	}
	/**
	 * displayCompetitionsFromDatabase method displays competetions that are listed in the database.
	 * @version 1.0
	 * @author Martin
	 * 
	 */
	public void displayCompetitionsFromDatabase () throws SQLException {
		String query = "SELECT c.description, c.id, c.date FROM competitions AS c";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		System.out.println("Competitions currently in database:");
		System.out.println("ID \tDescription");
		while (resultSet.next()) {
			System.out.println( resultSet.getString("id") + "\t" + resultSet.getString("description")+ " on " + resultSet.getDate("date")); 
		}
		System.out.println("\nTo use multiple ID's separate them with commas\nInsert the competition ID(s) to use:");
		resultSet.close();
		statement.close();	
	}
	/**
	 * readDatabase method reads data from the database and outputs a String array.
	 * The String array can be later processed by the PointsForObjects class.
	 * @param competition - competition ID(s) in the database. Defines the competition(s) that will be used for the final points calculation 
	 * and ordering of the athletes. To input pultiple IDs they have to be seperated by commas
	 * @version 1.0
	 * @author Martin
	 * @throws SQLException 
	 */
	public String[] readDatabase(String competition) throws SQLException {
		String query = "SELECT a.name, a.dob, a.country_code, r.race_100m, r.long_jump, r.shot_put, r.high_jump, r.race_400m, r.hurdles_110m, r.discus_throw, r.pole_vault, r.javelin_throw, r.race_1500m"
			+ " FROM results AS r INNER JOIN athletes AS a ON a.id = r.athlete_id "
			+ " WHERE r.competition_id = " + competition.replace(",", " OR ");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		String [] list = extractData(resultSet); 
		resultSet.close();
		statement.close();
		return list;
	}
	/**
	 * extractData method reads data from the database result set and outputs a String array.
	 * The String array can be later processed by the PointsForObjects class.
	 * @param rs - a result set from the database. The result set table columns are: name, date of birth,
	 * 2-letter ISO country code, 100m result, long jump result,... (all 10 events)
	 * @version 1.0
	 * @author Martin
	 * @throws SQLException
	 */
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
