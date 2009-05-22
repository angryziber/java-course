package net.azib.java.lessons.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MySQLDemo
 *
 * @author anton
 */
public class MySQLDemo {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://java.azib.net:3306/decathlon", "java", "java");
		
		System.out.println(conn.getMetaData().getDatabaseProductName());
		System.out.println(conn.getMetaData().getDatabaseProductVersion());
		System.out.println(conn.getMetaData().getDriverMajorVersion());
		
		ResultSet tables = conn.getMetaData().getTables("", "", "", null);
		while (tables.next()) {
			System.out.println(tables.getString("TABLE_NAME"));
		}
		
		conn.close();
	}
}
