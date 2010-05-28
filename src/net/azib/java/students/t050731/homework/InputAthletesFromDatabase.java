package net.azib.java.students.t050731.homework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

import com.mysql.jdbc.Connection;

/**
 * InputAthletesFromDatabase
 * 
 * This class handles the input from database
 * 
 * @author Raigo
 */
public class InputAthletesFromDatabase {
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	private ArrayList<Integer> idValues = new ArrayList<Integer>();
	private HelperMethods helper = new HelperMethods();

	/**
	 * This method converts reads athlete information from database
	 * 
	 * @param competition
	 *            contains competition id or name
	 */
	protected ArrayList<Athlete> getAthletesFromDatabase(String competition) {
		if (competition.equals("")) {
			System.out.println("Invalid competition id/name.");
			return null;
		}
		try {
			getConnection();
		}

		catch (SQLException e) {
			System.out.println("Unable to get connection to database.");
			return null;
		}
		catch (IOException e) {
			System.out.println("Unable to find db.properties file:");
			System.out.println(helper.getFullPath("db.properties"));
			return null;
		}
		createQueryString();
		try {
			try {
				getAthletesResults(Integer.parseInt(competition));
			}
			catch (NumberFormatException e) {
				getIDValues(competition);
			}
		}
		catch (SQLException e) {
			System.out.println("Unable to get competition ID-s.");
			return null;
		}
		if (idValues.size() > 1)
			System.out.println("More than one matching competition id-s were detected. Listing results from all competitions.");
		for (Integer id : idValues) {
			getAthletesResults(id);
			Collections.sort(athletes, new ScoreComparator());
		}
		try {
			connection.close();
		}
		catch (SQLException e) {
			System.out.println("Unable to close connection to database.");
		}
		return athletes;
	}

	private void getConnection() throws SQLException, IOException {
		Properties p = new Properties();
		InputStream in = getClass().getResourceAsStream("db.properties");
		p.load(in);
		in.close();

		String url = p.getProperty("db.url");
		String username = p.getProperty("db.username");
		String password = p.getProperty("db.password");

		connection = (Connection) DriverManager.getConnection(url, username, password);
	}

	private void getIDValues(String param) throws SQLException {
		String query = "SELECT id FROM competitions WHERE name = ?";
		stmt = connection.prepareStatement(query);
		stmt.setString(1, param);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			idValues.add(rs.getInt("id"));
		}
	}

	private String createQueryString() {
		String query;
		query = "SELECT A.name, A.dob, A.country_code, " + "R.race_100m, R.long_jump, R.shot_put, R.high_jump, R.race_400m, "
				+ "R.hurdles_110m, R.discus_throw, R.pole_vault, R.javelin_throw, R.race_1500m "
				+ "FROM athletes AS A INNER JOIN results AS R ON A.id = R.athlete_id WHERE R.competition_id = ?";
		return query;
	}

	private void getAthletesResults(int competitionID) {
		try {
			HelperMethods helper = new HelperMethods();
			stmt = connection.prepareStatement(createQueryString());
			stmt.setInt(1, competitionID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				try {
					athletes.add(helper.verifyAndCreateAthlete(rs.getString("A.name"), helper.formatDate(rs.getDate("A.dob")), rs
							.getString("A.country_code"), rs.getString("R.race_100m"), rs.getString("R.long_jump"), rs
							.getString("R.shot_put"), rs.getString("R.high_jump"), rs.getString("R.race_400m"), rs
							.getString("R.hurdles_110m"), rs.getString("R.discus_throw"), rs.getString("R.pole_vault"), rs
							.getString("R.javelin_throw"), rs.getString("R.race_1500m")));
				}
				catch (Exception e) {
					System.out.println("Input line from database is not correctly formatted. Skipping line.");
				}
			}
		}
		catch (Exception e) {
			System.out.println("Unable to create SQL query.");
		}
	}
}
