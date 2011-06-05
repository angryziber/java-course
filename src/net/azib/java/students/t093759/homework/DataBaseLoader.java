package net.azib.java.students.t093759.homework;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author dionis
 *         5/30/114:00 AM
 */
public class DataBaseLoader implements AthletesLoader {
	private static final String DATE_OF_BIRTH_FORMAT = "yyyy-MM-dd";
	Connection connection;
	ResourceBundle dbProperties;
	private boolean connectionIsCreatedByMe;
	private static final AthleteDataLoaderHelper ATHLETE_DATA_LOADER_HELPER_INSTANCE = AthleteDataLoaderHelper.getInstance();
	PrintStream err = System.err;

	public DataBaseLoader() {
		loadDbProperties();
	}

	private void loadDbProperties() {
		try {
			dbProperties = new PropertyResourceBundle(DecathlonCalculator.class.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Athlete> load(Object... additionalParams) {
		if (additionalParams.length < 1) throw new IllegalArgumentException("One parameter should be");
		if (!(additionalParams[0] instanceof String)) throw new IllegalArgumentException("One parameter should be");
		if (connection == null) {
			connectionIsCreatedByMe = true;
			openMySQLConnection();
		}

		List<Athlete> athletes = new ArrayList<Athlete>(100);
		String competitionIdOrName = (String) additionalParams[0];

		tryToLoadAthletesForCompetition(athletes, competitionIdOrName);
		if (connectionIsCreatedByMe) closeQuietly();
		return athletes;
	}

	private void openMySQLConnection() {
		try {
			String host = dbProperties.getString("db.host");
			int port = Integer.valueOf(dbProperties.getString("db.port"));
			String database = dbProperties.getString("db.name");
			String user = dbProperties.getString("db.user");
			String password = dbProperties.getString("db.password");
			connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
	}

	private void tryToLoadAthletesForCompetition(List<Athlete> athletes, String competitionIdOrName) {
		try {
			int id = getIdOfCompetition(competitionIdOrName);
			if (id == -1) throw new NoSuchCompetitionException();

			loadDataForAllAthletesFromCompetition(athletes, id);
		} catch (NoSuchCompetitionException e) {
			err.println("No such competition");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private void loadDataForAllAthletesFromCompetition(List<Athlete> athletes, int id) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sqlWithInnerJoin());
		preparedStatement.setInt(1, id);

		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			tryToLoadDataForOneAthlete(athletes, rs);
		}
	}

	private void tryToLoadDataForOneAthlete(List<Athlete> athletes, ResultSet rs) {
		try {
			Athlete.Builder builder = new Athlete.Builder();
			loadOneAthletesAllFields(rs, builder);
			athletes.add(builder.build());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private void loadOneAthletesAllFields(ResultSet resultSetToLoadFrom, Athlete.Builder builder) throws Exception {
		int i = 1;
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadNameUsing(builder, resultSetToLoadFrom.getString(i++));
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadDateOfBirthUsing(builder, resultSetToLoadFrom.getString(i++), DATE_OF_BIRTH_FORMAT);
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadCountryISO2LetterCodeUsing(builder, resultSetToLoadFrom.getString(i++));
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadOneHundredMeterSprintTimeUsing(builder, resultSetToLoadFrom.getString(i++));
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadLongJumpLengthUsing(builder, resultSetToLoadFrom.getString(i++));
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadShotPutLengthUsing(builder, resultSetToLoadFrom.getString(i++));
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadHighJumpHeightUsing(builder, resultSetToLoadFrom.getString(i++));
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadFourHundredMeterSprintTimeUsing(builder, resultSetToLoadFrom.getString(i++));
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadOneHundredTenMeterHurdlesTimeUsing(builder, resultSetToLoadFrom.getString(i++));
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadDiscusThrowLengthUsing(builder, resultSetToLoadFrom.getString(i++));
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadPoleVaultHeightUsing(builder, resultSetToLoadFrom.getString(i++));
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadJavelinThrowLengthUsing(builder, resultSetToLoadFrom.getString(i++));
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadThousandFiveHundredMeterRaceTimeUsing(builder, resultSetToLoadFrom.getString(i));
	}

	private String sqlWithInnerJoin() {
		return "SELECT a.name, a.dob, a.country_code, " +
				"r.race_100m, r.long_jump, r.shot_put, r.high_jump, r.race_400m, r.hurdles_110m, r.discus_throw," +
				"r.pole_vault, r.javelin_throw, r.race_1500m " +
				"FROM athletes as a " +
				"INNER JOIN results as r" +
				" ON r.athlete_id=a.id" +
				" INNER JOIN competitions AS c" +
				"  ON c.id=? AND r.competition_id=c.id ORDER BY c.id ASC";
	}

	private int getIdOfCompetition(String value) throws SQLException {
		int id = -1;
		try {
			id = Integer.parseInt(value);
			if (id == -1) throw new NoSuchCompetitionException();
		} catch (NumberFormatException e) {
			PreparedStatement prepStat = connection.prepareStatement("SELECT id FROM competitions WHERE name LIKE ? LIMIT 1");
			prepStat.setString(1, value);
			ResultSet resultSet = prepStat.executeQuery();

			if (resultSet.next())
				id = resultSet.getInt(1);
		}
		return id;
	}

	private void closeQuietly() {
		try {
			connection.close();
		} catch (SQLException ignore) {

		}
	}
}
