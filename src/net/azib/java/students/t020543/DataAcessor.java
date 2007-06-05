package net.azib.java.students.t020543;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAcessor {
	
	protected Connection connection;
	
	public void initializeConnection(String url) throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver");

		connection = DriverManager.getConnection(url);
		//connection = DriverManager.getConnection();
	}
	
	public void releaseConnection() throws SQLException{
		connection.close();
	}
	
}
