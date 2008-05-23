package net.azib.java.students.t030633.homework.view.in;

import net.azib.java.students.t030633.homework.DecathlonCalculator;
import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.AthleteBuilder;
import net.azib.java.students.t030633.homework.model.Event;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
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

	Database() {}

	Database(Connection conn) {
		this.conn = conn;
	}

	private Connection getConnection(File properties) throws SQLException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(properties));
		return DriverManager.getConnection(reader.readLine(), reader.readLine(), reader.readLine());
	}

	private ResultSet getAthletes(Connection conn, String key) throws IOException {
		try {
			// Athlete parameters
			String sql = "SELECT athletes.name, athletes.dob, athletes.country_code, "
					// Results (in the same order they are in Event constants)
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
			catch (NumberFormatException e) { // Happens when search criterion is a competition name
			}
			stmt.setString(2, key);
			return stmt.executeQuery();
		}
		catch (SQLException e) {
			throw new IOException("Database access error.", e);
		}
	}

	private List<Athlete> parseAthletes(ResultSet results) throws SQLException {
		List<Athlete> list = new LinkedList<Athlete>();
		while (results.next()) {
			builder.name(results.getString("name"));
			builder.date(results.getDate("dob"));
			builder.country(results.getString("country_code"));
			int i = 4; // columns 4+ are results
			// Results have been selected in the same order as Event constants
			for (Event e : Event.values()) {
				builder.addResult(e, ((double) Math.round(results.getFloat(i++) * 100) / 100));
			}
			list.add(builder.build());
		}
		return list;
	}

	public List<Athlete> read(String... search) throws IOException {
		try {
			if (conn == null) { // Connection has been set already when testing 
				File properties = new File(DecathlonCalculator.class.getResource("db.properties").toURI());
				if (!properties.exists())
					throw new IOException("Unable to find properties file.");
				conn = getConnection(properties);
			}
			// Database read has one parameter, it should be the search
			// criterion
			return parseAthletes(getAthletes(conn, search[0]));
		}
		catch (ArrayIndexOutOfBoundsException e) {
			throw new IOException("Competition name or number not specified.");
		}
		catch (SQLException e) {
			throw new IOException("Error reading athlete from database.", e);
		}
		catch (URISyntaxException e) {
			throw new IOException("Unable to find properties file.", e);
		}
	}

}
