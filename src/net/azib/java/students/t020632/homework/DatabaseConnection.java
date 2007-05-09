package net.azib.java.students.t020632.homework;

import java.io.*;
import java.sql.*;
import java.util.*;


/**
 * DatabaseConnection
 *
 * @author Marek
 */
public class DatabaseConnection {
	
	
	public void connectDatabase(){
		try{
			Properties properties = new Properties();
			properties.setProperty("user", "java");
			properties.setProperty("password", "java");
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			
			System.out.println("gg");
			//Connection con = DriverManager.getConnection("jdcb:mysql:lala", properties);
			Connection con = DriverManager.getConnection("jdbc:mysql://srv.azib.net:3306/decathlon", properties);
			
			Statement selectStatement = con.createStatement();
			
			try{
				ResultSet rs = selectStatement.executeQuery("SELECT * FROM competitions");
				try{
					int columns = 0;
					while(rs.next()){
						columns = rs.getMetaData().getColumnCount();
						for(int i = 1; i <= columns; i++){
							System.out.println(rs.getObject(i));
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

			
			System.out.println("gg");

			
		}
	
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void main(String [] args){
		DatabaseConnection dbc = new DatabaseConnection();
		dbc.connectDatabase();
	}
	
	
	

}
