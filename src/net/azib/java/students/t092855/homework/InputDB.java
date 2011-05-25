package net.azib.java.students.t092855.homework;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


/**
 *  Database input strategy. Gets decathlon competition data from database.
 * @author t092855
 */
public class InputDB implements InputStrategy {

	/**
	 * Get decathlon competition data from database. Database properties are in the db.properties file.
	 * @param arg argument containing decathlon competition ID or name
	 * @return competition data
	 */
	@Override
	public Competition getData(String... arg) {

		return getDataFromDatabase(arg[0], getDatabaseProperties());
	}

	Competition getDataFromDatabase(String arg, Properties properties) {
		Competition competition = new Competition();

		String getAthleteDataQuery = "SELECT athletes.name, athletes.dob, athletes.country_code, " +
				"results.race_100m, results.long_jump, results.shot_put, results.high_jump, results.race_400m, " +
				"results.hurdles_110m, results.discus_throw, results.pole_vault, results.javelin_throw, results.race_1500m " +
				"FROM athletes, results, competitions " +
				"WHERE athletes.id = results.athlete_id " +
				"AND results.competition_id = competitions.id " +
				"AND (competitions.id = ? OR competitions.name = ?)";

		Connection conn = null;

		try {
			String url = properties.getProperty("db.url");
			String username= properties.getProperty("db.username");
			String password  = properties.getProperty("db.password");

			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement athleteDataQuery = conn.prepareStatement(getAthleteDataQuery);
			athleteDataQuery.setString(1, arg);
			athleteDataQuery.setString(2, arg);
			ResultSet resultSet = athleteDataQuery.executeQuery();

			while(resultSet.next()) {
				Athlete athlete = parseAthlete(resultSet);
				if (athlete == null) {
					System.out.println(Error.ERROR_DB_ATHLETE_PARSING_FAILED.getErrorText());
					continue;
				}

				DecathlonEvents decathlonEvents  = parseDecathlonEvents(resultSet);
				if (decathlonEvents == null) {
					System.out.println(Error.ERROR_DB_ATHLETE_RESULTS_PARSING_FAILED.getErrorText());
					continue;
				}
				athlete.setDecathlonEvent(decathlonEvents);

				competition.addAthlete(athlete);
			}
		} catch (SQLException e) {
			System.out.println(Error.ERROR_DB_CONNECTION.getErrorText());
		}
		finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(Error.ERROR_DB_CLOSE.getErrorText());
				}
		}
		return competition;
	}

	private Athlete parseAthlete (ResultSet athleteSet) throws SQLException {
		SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM);

		Athlete athlete = new Athlete();
		athlete.setName(athleteSet.getString("name"));

		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(athleteSet.getString("dob"));
			athlete.setBirthday(dateFormat.format(date));
		} catch (ParseException e) {
			return null;
		}
		athlete.setCountry(athleteSet.getString("country_code"));
		return athlete;
	}

	private DecathlonEvents parseDecathlonEvents(ResultSet athleteSet) throws SQLException {
		String[] eventColumns = {"race_100m", "long_jump", "shot_put",
				"high_jump", "race_400m", "hurdles_110m", "discus_throw",
				"pole_vault", "javelin_throw","race_1500m"};
		double[] results = new double[eventColumns.length];
		for(int i = 0; i < eventColumns.length; i++) {
			results[i] = athleteSet.getDouble(eventColumns[i]);
		}
		return new DecathlonEvents(results);
	}

	private Properties getDatabaseProperties() {
		Properties props = new Properties();
		InputStream in = null;
		try {
			in = getClass().getResourceAsStream("db.properties");
			props.load(in);
		} catch (FileNotFoundException e) {
			System.out.println(Error.ERROR_DB_PROPERTIES_FILE_NOT_FOUND.getErrorText());
		} catch (IOException e) {
			System.out.println(Error.ERROR_DB_PROPERTIES_READ.getErrorText());
		}
		finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.out.println(Error.ERROR_DB_PROPERTIES_FILE_NOT_FOUND.getErrorText());
				}
			}
		}
		return props;
	}
}
