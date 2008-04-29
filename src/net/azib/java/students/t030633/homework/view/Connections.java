package net.azib.java.students.t030633.homework.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection.
 * 
 * @author t030633
 */
public class Connections {

	public static String DATABASE = "jdbc:mysql://srv.azib.net:3306/decathlon";
	public static String USER = "java";
	public static String PASS = "java";

	/**
	 * @return Connection - connection to database
	 * @throws SQLException
	 *             if unable to connect
	 */
	public Connection getDatabaseConnection() throws SQLException {
		return DriverManager.getConnection(DATABASE, USER, PASS);
	}

}
