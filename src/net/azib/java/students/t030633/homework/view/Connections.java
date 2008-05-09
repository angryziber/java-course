package net.azib.java.students.t030633.homework.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection.
 * 
 * @author t030633
 */
public class Connections {

	private static final String PROPERTIES_FILENAME = "db.properties";

	private static final String DB_ERROR = "Unable to read database properties file.";

	public static String DATABASE = "jdbc:mysql://srv.azib.net:3306/decathlon";
	public static String USER = "java";
	public static String PASS = "java";

	private static String parameter;

	public static void setParameter(String param) {
		parameter = param;
	}

	public static String getParameter() {
		return parameter;
	}

	/**
	 * @return Connection - connection to database
	 * @throws SQLException
	 *             if unable to connect
	 * @throws FileNotFoundException
	 *             if unable to read database properties file
	 */
	public Connection getDatabaseConnection() throws FileNotFoundException, SQLException {
		File properties;
		Connection conn = null;
		try {
			URI path = Files.class.getResource("..").toURI();
			properties = new File(path.getPath(), PROPERTIES_FILENAME);
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(properties), "UTF-8"));
			conn = DriverManager.getConnection(reader.readLine(), reader.readLine(), reader.readLine());
		}
		catch (URISyntaxException e) {
			throw new FileNotFoundException(DB_ERROR);
		}
		catch (UnsupportedEncodingException e) {
			System.err.println("UTF-8 encoding not supported.");
		}
		catch (IOException e) {
			throw new FileNotFoundException(DB_ERROR);
		}
		return conn;
	}

}
