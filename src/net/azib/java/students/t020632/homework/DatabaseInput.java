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
	
	
	public DatabaseInput(int comp, String con){
		competition = comp;
		connection = con;
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
			
			Connection con = DriverManager.getConnection("jdbc:mysql://srv.azib.net:3306/decathlon", properties);
			
			Statement selectStatement = con.createStatement();
			
			
			try{
				ResultSet rs = selectStatement.executeQuery("SELECT * FROM competitions");
				try{
					eventInfos = EventInfo.values();
					while(rs.next()){
						name = (String) rs.getObject(0);
						date = (String) rs.getObject(1);
						country = (String) rs.getObject(2);
						result = new AthleteResults(name, date, country);
						
						for(int i = 0; i <= 9; i++){
							info = eventInfos[i];
							event = result.createEvent(info);
							event.setResult(rs.getFloat(3+i));
							result.addEvent(event);
							results.add(result);
							System.out.println(rs.getFloat(3+i));
						}
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
