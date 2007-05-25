package net.azib.java.students.t020543.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAcessor {
	
	protected Connection connection;
	
	public void initializeConnection(String url, String user, String password) throws Exception 
	{
		Class.forName("/java/lib/mysql-connector.jar");

		connection = DriverManager.getConnection(url, user, password);
	}
	
	public void releaseConnection() throws SQLException{
		connection.close();
	}
	
}
