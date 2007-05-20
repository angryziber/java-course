package net.azib.java.students.t020632.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

/**
 * DatabaseInput reads results from database
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
	}
	
	/**
	 * Reads results from database. After connecting database all competitions
	 * found from database are showed to user. User has to pick one competition
	 * which is included for the point calculation. Results are added to AthleteResults
	 * list  
	 */
	public List<AthleteResults> read(){
		
		List<AthleteResults> results = new ArrayList<AthleteResults>();
		AthleteResults result;
		UnitsConverter converter;
		EventInfo [] eventInfos;
		EventInfo info;
		Event event;
		float fResult;
		String name;
		String date;
		String country;
		String id;
		String description;
		
		try{
			Properties properties = new Properties();
			properties.setProperty("user", "java");
			properties.setProperty("password", "java");
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection(connection, properties);
			
			Statement selectStatement = con.createStatement();
			
			
			try{
				
				ResultSet rs2 = selectStatement.executeQuery("SELECT * FROM competitions");
				
				System.out.println("id \t description");
				while(rs2.next()){
					id = rs2.getObject(1).toString();
					description = (String) rs2.getObject(4);
					System.out.println(id + "\t" + description);
				}
				
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("There are several competitions in the database");
				System.out.println("Enter the id number for the competition!");
				
				competition = Integer.parseInt(in.readLine());
				
				sql = "SELECT name, dob, a.country_code, race_100m, long_jump, shot_put, high_jump, race_400m, ";
				sql = sql + "hurdles_110m, discus_throw, pole_vault, javelin_throw, race_1500m ";
				sql = sql + "FROM competitions AS c INNER JOIN (results AS r INNER JOIN athletes AS a ";
				sql = sql + " ON r.athlete_id = a.id) ON r.competition_id = c.id WHERE c.id = " + competition;
				
				
				ResultSet rs = selectStatement.executeQuery(sql);
				try{
					eventInfos = EventInfo.values();
					
					while(rs.next()){
						name = (String) rs.getObject(1);
						date = rs.getObject(2).toString();
						country = (String) rs.getObject(3);
		
						result = new AthleteResults(name, date, country);
						
						converter = UnitsConverter.getUnitsConverter();
						
						for(int i = 1; i <= 10; i++){
							info = eventInfos[i-1];
							event = result.createEvent(info);
							fResult = converter.convert(info, rs.getString(3+i));
							event.setResult(fResult);
							event.setResult(rs.getString(3+i));
							result.addEvent(event);
							//System.out.println(rs.getFloat(3+i));
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
