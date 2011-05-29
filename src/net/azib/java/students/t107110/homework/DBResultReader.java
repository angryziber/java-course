package net.azib.java.students.t107110.homework;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import static net.azib.java.students.t107110.homework.DecathlonException.decathlonException;

/**
 * @author Eduard Shustrov
 */
public class DBResultReader implements ResultReader {
	private static final String QUERY_COMPETITION_BY_ID = "SELECT id FROM competitions WHERE id=?";
	private static final String QUERY_COMPETITION_BY_NAME = "SELECT id FROM competitions WHERE name=?";
	private static final String QUERY_RESULTS_BY_COMPETITION =
			"SELECT a.*, r.* FROM athletes a, results r WHERE r.competition_id=? AND r.athlete_id=a.id";

	private final Connection connection;
	private final Statement statement;
	private final ResultSet results;

	public DBResultReader(final InputStream propertiesStream, final String competition) throws DecathlonException {
		try {
			connection = getConnection(loadProperties(propertiesStream));
			statement = queryCompetitionResults(getCompetitionID(competition));
			results = statement.getResultSet();
		} catch (SQLException e) {
			close();
			throw decathlonException(e, Message.CANNOT_READ_DB);
		} catch (DecathlonException e) {
			close();
			throw e;
		}
	}

	@Override
	public Result read() throws DecathlonException {
		try {
			if (!results.next()) return null;
			final ResultBuilder builder = new ResultBuilder();
			builder.setAthleteName(results.getString("name"));
			builder.setBirthDay(results.getDate("dob"));
			builder.setCountry(results.getString("country_code"));
			builder.setSprint100m(results.getDouble("race_100m"));
			builder.setLongJump(results.getDouble("long_jump"));
			builder.setShotPut(results.getDouble("shot_put"));
			builder.setHighJump(results.getDouble("high_jump"));
			builder.setSprint400m(results.getDouble("race_400m"));
			builder.setHurdles110m(results.getDouble("hurdles_110m"));
			builder.setDiscusThrow(results.getDouble("discus_throw"));
			builder.setPoleVault(results.getDouble("pole_vault"));
			builder.setJavelinThrow(results.getDouble("javelin_throw"));
			builder.setRace1500m(results.getDouble("race_1500m"));
			return builder.getResult();
		} catch (SQLException e) {
			close();
			throw decathlonException(e, Message.CANNOT_READ_DB);
		}
	}

	@Override
	public void close() {
		try {
			if (results != null) results.close();
		} catch (SQLException ignored) {
		}
		try {
			if (statement != null) statement.close();
		} catch (SQLException ignored) {
		}
		try {
			if (connection != null) connection.close();
		} catch (SQLException ignored) {
		}
	}

	private static Properties loadProperties(final InputStream propertiesStream) throws DecathlonException {
		final Properties properties = new Properties();
		try {
			properties.load(propertiesStream);
		} catch (IOException e) {
			throw decathlonException(e, Message.CANNOT_LOAD_PROPERTIES);
		} finally {
			IOUtils.closeQuietly(propertiesStream);
		}
		return properties;
	}

	private static Connection getConnection(final Properties properties) throws DecathlonException {
		final String url = properties.getProperty("db.url");
		final String user = properties.getProperty("db.user");
		final String password = properties.getProperty("db.password");
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw decathlonException(e, Message.CANNOT_CONNECT_TO_DB);
		}
	}

	private long getCompetitionID(final String competition) throws SQLException, DecathlonException {
		final long competitionNumber = parseCompetitionID(competition);
		if (isCompetitionID(competitionNumber)) return competitionNumber;
		return getCompetitionIDByName(competition);
	}

	private static long parseCompetitionID(final String competition) {
		try {
			final long competitionID = Long.parseLong(competition);
			if (competitionID < 0) return 0;
			else return competitionID;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private boolean isCompetitionID(final long id) throws SQLException {
		final PreparedStatement statement = connection.prepareStatement(QUERY_COMPETITION_BY_ID);
		try {
			statement.setLong(1, id);
			final ResultSet results = statement.executeQuery();
			try {
				return results.next();
			} finally {
				results.close();
			}
		} finally {
			statement.close();
		}
	}

	private long getCompetitionIDByName(final String competitionName) throws SQLException, DecathlonException {
		final PreparedStatement statement = connection.prepareStatement(QUERY_COMPETITION_BY_NAME);
		try {
			statement.setString(1, competitionName);
			final ResultSet results = statement.executeQuery();
			try {
				if (!results.next()) throw decathlonException(Message.NO_SUCH_COMPETITION);
				final long competitionID = results.getLong("id");
				if (results.next()) throw decathlonException(Message.NOT_UNIQUE_COMPETITION);
				return competitionID;
			} finally {
				results.close();
			}
		} finally {
			statement.close();
		}
	}

	private Statement queryCompetitionResults(final long competition) throws SQLException {
		final PreparedStatement statement = connection.prepareStatement(QUERY_RESULTS_BY_COMPETITION);
		try {
			statement.setLong(1, competition);
			statement.executeQuery();
			return statement;
		} catch (SQLException e) {
			statement.close();
			throw e;
		}
	}
}
