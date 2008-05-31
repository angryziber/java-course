package net.azib.java.students.t010588.homework.importer;

import net.azib.java.students.t010588.homework.Athlete;
import net.azib.java.students.t010588.homework.FieldEventResult;
import net.azib.java.students.t010588.homework.Result;
import net.azib.java.students.t010588.homework.RunningEventResult;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.jdbc.Driver;

/**
 * Imports athletes from database
 *
 * @author Vjatseslav Rosin, 010588
 */
public class DatabaseImporter implements AthleteImporter {

	/** Data format for database */
	public DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd");

	private List<Athlete> athletes;

	private String competitionName = "";

	private int competitionId = -1;

	/**
	 * @param inputStream
	 *            with database connection information
	 * @param competition
	 *            id or name
	 * @throws WrongFormatException
	 *             in case of wrong data base properties or invalid data
	 */
	public DatabaseImporter(InputStream inputStream, String competition) throws WrongFormatException {
		athletes = new ArrayList<Athlete>();

		try {
			if (competition != null) {
				this.competitionName = competition;
				try {
					this.competitionId = Integer.parseInt(competition);
				}
				catch (NumberFormatException e) {
					this.competitionId = -1;
				}
			}

			DriverManager.registerDriver(new Driver());

			Properties properties = new Properties();
			properties.load(inputStream);
			String url = properties.getProperty(DBConstants.URL_PROP);
			String login = properties.getProperty(DBConstants.LOGIN_PROP);
			String password = properties.getProperty(DBConstants.PASSWORD_PROP);

			Connection connection = DriverManager.getConnection(url, login, password);

			loadAthletes(connection);

			connection.close();
		}
		catch (Exception e) {
			throw new WrongFormatException("Error reading database properties: " + e.getMessage());
		}
	}

	/**
	 * @param connection
	 *            to database
	 * @throws WrongFormatException
	 *             in a case of invalid connection properties or database
	 *             structure
	 */
	private void loadAthletes(Connection connection) throws WrongFormatException {
		try {
			// Athlete parameters
			PreparedStatement statement = connection.prepareStatement(DBConstants.SELECT_SQL);
			statement.setInt(1, competitionId);
			statement.setString(2, competitionName);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Athlete athlete = new Athlete();
				athlete.setName(resultSet.getString("name"));
				athlete.setBirhday(DATE_FORMAT.parse(resultSet.getString("dob")));
				athlete.setCountry(resultSet.getString("country_code").toCharArray());

				Result[] results = new Result[10];
				results[0] = new RunningEventResult(0, resultSet.getFloat("race_100m"));
				results[1] = new FieldEventResult(1, resultSet.getFloat("long_jump"));
				results[2] = new FieldEventResult(2, resultSet.getFloat("shot_put"));
				results[3] = new FieldEventResult(3, resultSet.getFloat("high_jump"));
				results[4] = new RunningEventResult(4, resultSet.getFloat("race_400m"));
				results[5] = new RunningEventResult(5, resultSet.getFloat("hurdles_110m"));
				results[6] = new FieldEventResult(6, resultSet.getFloat("discus_throw"));
				results[7] = new FieldEventResult(7, resultSet.getFloat("pole_vault"));
				results[8] = new FieldEventResult(8, resultSet.getFloat("javelin_throw"));
				results[9] = new RunningEventResult(9, resultSet.getFloat("race_1500m"));

				athlete.setResults(results);

				athletes.add(athlete);
			}
		}
		catch (Exception e) {
			throw new WrongFormatException("Database data is not valid");
		}
	}

	public List<Athlete> getAthletes() {
		return athletes;
	}
}
