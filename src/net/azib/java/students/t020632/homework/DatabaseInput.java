package net.azib.java.students.t020632.homework;

import java.sql.*;
import java.util.*;

/**
 * DatabaseInput
 *
 * @author Marek Soobik t020632
 */

public class DatabaseInput implements Input {

	private String connection;
	private int competition;
	private String sql;
	
	
	public DatabaseInput(int comp, String con){
		competition = comp;
		connection = con;
		sql = "SELECT name, dob, a.country_code, race_100m, long_jump, shot_put, high_jump, race_400m, ";
		sql = sql + "hurdles_110m, discus_throw, pole_vault, javelin_throw, race_1500m ";
		sql = sql + "FROM competitions AS c INNER JOIN (results AS r INNER JOIN athletes AS a ";
		sql = sql + " ON r.athlete_id = a.id) ON r.competition_id = c.id WHERE c.id = " + competition;
	}
	
	
	public List<AthleteResults> read(){
		
		List<AthleteResults> results = new ArrayList<AthleteResults>();
		AthleteResults result;
		EventInfo [] eventInfos;
		EventInfo info;
		Event event;
		String name;
		String date;
		String country;
		
		try{
			Properties properties = new Properties();
			properties.setProperty("user", "java");
			properties.setProperty("password", "java");
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection(connection, properties);
			
			Statement selectStatement = con.createStatement();
			System.out.println(sql);
			
			
			try{
				ResultSet rs = selectStatement.executeQuery(sql);
				try{
					eventInfos = EventInfo.values();
					
					while(rs.next()){
						name = (String) rs.getObject(1);
						date = rs.getObject(2).toString();
						country = (String) rs.getObject(3);
						System.out.println(name + ", " + date + ", " + country);
						result = new AthleteResults(name, date, country);
						
						for(int i = 1; i <= 10; i++){
							info = eventInfos[i-1];
							event = result.createEvent(info);
							event.setResult(rs.getFloat(3+i));
							event.setResult(rs.getString(3+i));
							result.addEvent(event);
							System.out.println(rs.getFloat(3+i));
						}
						
						results.add(result);
					}
				}
				finally{
					rs.close();
				}
			}
			finally{
				selectStatement.close();
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return results;
	}

}
