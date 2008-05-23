package net.azib.java.students.t030633.homework.view.in;

import net.azib.java.students.t030633.homework.DecathlonCalculator;
import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.AthleteBuilder;
import net.azib.java.students.t030633.homework.model.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Reads decathlon athletes from a database using simple JDBC connect.
 * 
 * @author t030633
 */
public class Database implements Input {

	private AthleteBuilder builder = new AthleteBuilder();
	private Connection conn;

	Database() {
	}

	Database(Connection conn) {
		this.conn = conn;
	}

	private Connection getConnection(InputStream properties) throws SQLException, IOException, ClassNotFoundException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(properties));
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(reader.readLine(), reader.readLine(), reader.readLine());
	}

	private ResultSet getAthletes(Connection conn, String key) throws SQLException {
		// Athlete parameters
		String sql = "SELECT athletes.name, athletes.dob, athletes.country_code, "
				// Results (in the same order they are in Event)
				+ "results.race_100m, results.long_jump, results.shot_put, "
				+ "results.high_jump, results.race_400m, results.hurdles_110m, "
				+ "results.discus_throw, results.pole_vault, results.javelin_throw, "
				+ "results.race_1500m "
				// Selection
				+ "FROM athletes INNER JOIN results ON results.athlete_id = athletes.id "
				+ "INNER JOIN competitions ON results.competition_id = competitions.id "
				+ "WHERE competitions.id = ? OR competitions.name = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		try {
			stmt.setInt(1, Integer.parseInt(key));
		}
		catch (NumberFormatException e) {
			// Happens when search criterion is a competition name
			stmt.setInt(1, 0);
		}
		stmt.setString(2, key);
		return stmt.executeQuery();
	}

	private List<Athlete> parseAthletes(ResultSet results) throws SQLException {
		List<Athlete> list = new LinkedList<Athlete>();
		while (results.next()) {
			builder.name(results.getString("name"));
			builder.date(results.getDate("dob"));
			builder.country(results.getString("country_code"));
			int i = 4; // columns 4+ are results
			// Results have been selected in the same order as they are in Event
			for (Event e : Event.values()) {
				builder.addResult(e, ((double) Math.round(results.getFloat(i++) * 100) / 100));
			}
			list.add(builder.build());
		}
		return list;
	}

	public List<Athlete> read(String... search) throws IOException {
		InputStream properties = null;

		if (conn == null) { // Connection has already been set when testing
			try { // Try to open database connection
				properties = DecathlonCalculator.class.getResourceAsStream("db.properties");
				conn = getConnection(properties);
			}
			catch (SQLException e) {
				throw new IOException("Unable to connect to database.", e);
			}
			catch (IOException e) {
				throw new IOException("Unable to find properties file.", e);
			}
			catch (ClassNotFoundException e) {
				throw new IOException("Database driver not found.", e);
			}
			finally {
				properties.close();
			}
		}
		
		try { // Try to read athletes from the database
			// Database read has one parameter, it should be the search criterion
			return parseAthletes(getAthletes(conn, search[0]));
		}
		catch (ArrayIndexOutOfBoundsException e) {
			throw new IOException("Competition name or number not specified.", e);
		}
		catch (SQLException e) {
			throw new IOException("Unable to read athletes from database.", e);
		}
		finally {
			try {
				conn.close();
			}
			catch (SQLException e) {
				throw new IOException("Unable to close database connetion.", e);
			}
		}
	}

}
