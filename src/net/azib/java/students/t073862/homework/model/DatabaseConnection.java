package net.azib.java.students.t073862.homework.model;

/**
 * DatabaseConnection
 *
 * @author Pets
 */

import net.azib.java.students.t073862.homework.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * Used to interact with the database.
 */
public class DatabaseConnection {
	/**
	 * Loads database properties
	 */
	private Properties props = Util.loadDBProperties();
	
	/**
	 * The database connection in use
	 */
	private Connection con;
	/**
	 * A statement for running queries on
	 */
	private Statement statement;

	/**
	 * Tests we have a driver
	 */
	private void testForDriver() {
		try {
			Class.forName(props.getProperty("driver"));
		}
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.exit(1);
		}
	}
	private PreparedStatement loadDataFromID;
	private PreparedStatement loadDataFromName;
	/**
	 * Instantiates a new database connection
	 */
	public DatabaseConnection() {
		if(props == null) {
			System.out.println("Unable to load database properties");
			System.exit(1);
		}
		testForDriver();
		
		if(!createConnection()) {
			new Exception("Unable to connect to DataBase").printStackTrace();
			System.exit(1);
		}
		else {
			System.out.println("Database connection achieved.");
			try {
				loadDataFromID = con.prepareStatement("SELECT a.*,r.* FROM competitions as c LEFT JOIN results as r ON c.id = r.competition_id LEFT JOIN athletes as a ON r.athlete_id = a.id WHERE c.id = ?");
				loadDataFromName = con.prepareStatement("SELECT a.*,r.* FROM competitions as c LEFT JOIN results as r ON c.id = r.competition_id LEFT JOIN athletes as a ON r.athlete_id = a.id WHERE c.name = ?");
			}
			catch (SQLException e) {
				System.out.println("Unable to initilize prepared statements");
				e.printStackTrace();
				System.exit(1);
			}
			
		}
	}
	private boolean createConnection() {
		try {
			con = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("username"));
			statement = con.createStatement();
			statement.setEscapeProcessing(true);
			return isConnected();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean isConnected() {
		try {
			statement.executeQuery("SELECT CURRENT_DATE");
			return true;
		}
		catch(SQLException e) {
			return false;
		}
	}

	/**
	 * Closes the database conection.
	 *
	 * @throws SQLException if there was an error when closing the connection
	 */
	public void close() throws SQLException {
		con.close();
		con = null;
	}
	/**
	 * @return the loadDataFromID
	 */
	public PreparedStatement getLoadDataFromID() {
		return loadDataFromID;
	}
	/**
	 * @return the loadDataFromName
	 */
	public PreparedStatement getLoadDataFromName() {
		return loadDataFromName;
	}
}
