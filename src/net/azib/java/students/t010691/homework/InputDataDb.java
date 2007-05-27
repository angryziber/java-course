package net.azib.java.students.t010691.homework;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * InputDataDb
 * 
 * Database source.
 * Competition data is taken from database.
 *
 * @author Ilja Lutov
 */
class InputDataDb extends InputData {
	
	/**
	 * Constructor
	 * 
	 * Creates database connection
	 */
	public InputDataDb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://srv.azib.net:3306/decathlon", "java", "java");
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM athletes JOIN results ON athletes.id = results.athlete_id WHERE results.competition_id = 2");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error: database driver not found");
		}
		catch (SQLException e) {
			System.out.println("Error: unable to create database connection");
		}
	}

	/**
	 * Fetches single row from query result
	 * 
	 * @see net.azib.java.students.t010691.homework.InputData#nextResult()
	 */
	public Competitor nextResult() {
		try {
			result.next();

			String[] data = new String[13];
			
			data[0] = result.getString("name");
			data[1] = result.getString("dob").replaceFirst("(\\d{4})-(\\d{2})-(\\d{2})", "$3.$2.$1");
			data[2] = result.getString("country_code");
			data[3] = result.getString("race_100m");
			data[4] = result.getString("long_jump");
			data[5] = result.getString("shot_put");
			data[6] = result.getString("high_jump");
			data[7] = result.getString("race_400m");
			data[8] = result.getString("hurdles_110m");
			data[9] = result.getString("discus_throw");
			data[10] = result.getString("pole_vault");
			data[11] = result.getString("javelin_throw");
			data[12] = result.getString("race_1500m");
			
			// Create competitor instance
			Competitor competitor = createCompetitorFromRawData(data);
			
			// Fetch next row if data is not valid
			return competitor == null ? nextResult() : competitor;
		}
		catch (SQLException e) {
			return null;
		}
	}
	
	/**
	 * Closes query result resource
	 * 
	 * @see net.azib.java.students.t010691.homework.InputData#close()
	 */
	public void close() {
		try {
			result.close();
		}
		catch (SQLException e) {
			System.out.println("Error: unable to close resource");
		}
	}

	// Database connection
	Connection connection;
	
	// SQL statement
	Statement statement;
	
	// Query result resource
	ResultSet result;
}
