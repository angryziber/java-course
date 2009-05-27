package net.azib.java.students.t030520.homework.providers;

import net.azib.java.students.t030520.homework.Main;
import net.azib.java.students.t030520.homework.event.FieldEvent;
import net.azib.java.students.t030520.homework.event.TrackEvent;
import net.azib.java.students.t030520.homework.sportsman.EventResult;
import net.azib.java.students.t030520.homework.sportsman.SportsmanWithResults;
import net.azib.java.students.t030520.homework.util.Utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;


/**
 * Provides the reading from database.
 *
 * @author t030520
 */
public class DatabaseReader {

	private static final String dbPropertiesFile = "db.properties";

	/**
	 * @param id of competition.
	 * @return the list of sportsman's results.
	 * @throws SQLException
	 */
	public List<SportsmanWithResults> readSportsmanResultsFromDatabaseByCompetitionId(long id) throws SQLException {
		List<SportsmanWithResults> sportsmanWithResults = new ArrayList<SportsmanWithResults>();
		String query = "" +
				"SELECT a.name as name, " +
						"a.dob as birthday, " +
						"a.country_code as code, " +
						"race_100m as sprint100, " +
						"long_jump as longJump, " +
						"shot_put as shotPut, " +
						"high_jump as highJump, " +
						"race_400m as sprint400, " +
						"hurdles_110m as hurdles110, " +
						"discus_throw as discusThrow, " +
						"pole_vault as poleVault, " +
						"javelin_throw as javelinThrow, " +
						"race_1500m as race1500 " +
				"FROM competitions AS c " +
				"LEFT JOIN results AS r on c.id = r.competition_id " +
				"LEFT JOIN athletes AS a on a.id = r.athlete_id " +
				"WHERE c.id = ?";

		Connection conn = getConnection();
		PreparedStatement st = conn.prepareStatement(query);
		st.setLong(1, id);
		ResultSet rs = st.executeQuery();
		populateResults(rs,sportsmanWithResults);
		rs.close();
		st.close();
		conn.close();
		return sportsmanWithResults;
	}

	/**
	 * @param name of competition.
	 * @return the list of sportsman's results.
	 * @throws SQLException
	 */
	public List<SportsmanWithResults> readSportsmanResultsFromDatabaseByCompetitionName(String name) throws SQLException {
		List<SportsmanWithResults> sportsmanWithResults = new ArrayList<SportsmanWithResults>();
		String query = "" +
				"SELECT a.name as name, " +
						"a.dob as birthday, " +
						"a.country_code as code, " +
						"race_100m as sprint100, " +
						"long_jump as longJump, " +
						"shot_put as shotPut, " +
						"high_jump as highJump, " +
						"race_400m as sprint400, " +
						"hurdles_110m as hurdles110, " +
						"discus_throw as discusThrow, " +
						"pole_vault as poleVault, " +
						"javelin_throw as javelinThrow, " +
						"race_1500m as race1500 " +
				"FROM competitions AS c " +
				"LEFT JOIN results AS r on c.id = r.competition_id " +
				"LEFT JOIN athletes AS a on a.id = r.athlete_id " +
				"WHERE c.name = ?";

		Connection conn = getConnection();
		PreparedStatement st = conn.prepareStatement(query);
		st.setString(1, name);
		ResultSet rs = st.executeQuery();
		populateResults(rs,sportsmanWithResults);
		rs.close();
		st.close();
		conn.close();
		return sportsmanWithResults;
	}

	/**
	 * Creates the connection to the database.
	 * @return the connection
	 */
	private static Connection getConnection() {
		Properties props = new Properties();

		// Read data from properties file. 
		try {
			props.load(Main.class.getResourceAsStream(dbPropertiesFile));
		} catch (IOException e) {
			System.out.println("Could not load database properties from file.");
			System.exit(1);
		}

		// Creates the connection.
		Connection conn = null;
		try {
			String connStr = "jdbc:mysql://" + props.getProperty("Server") + "/" + props.getProperty("Database");
			conn = DriverManager.getConnection(connStr, props.getProperty("User"), props.getProperty("Password"));
		} catch (SQLException e) {
			return null;
		}

		if (conn == null) {
			System.out.println("Could not establish a connection to the database.");
			System.exit(1);
		}

		return conn;
	}

	private void populateResults(ResultSet rs, List<SportsmanWithResults> sportsmanWithResults)  throws SQLException {
		while (rs.next()) {
			SportsmanWithResults sportsman = new SportsmanWithResults();

			// Set name
			String name = rs.getString("name");
			if (Utils.isEmpty(name)) {
				continue;
			}
			sportsman.setName(name);

			// Set birthday
			try {
				Date birthday = rs.getDate("birthday");
				sportsman.setBirthDate(birthday);
			} catch (SQLException e) {
				continue;
			}

			// Set country code
			String code = rs.getString("code");
			if (Utils.isEmpty(code)) {
				continue;
			}
			sportsman.setCountryCode(code);

			// Set sprint100
			float sprint100 = rs.getFloat("sprint100");
			if (sprint100 <= 0.0) {
				continue;
			}
			sportsman.getResults().add(new EventResult(sprint100, TrackEvent.SPRINT100));

			// Set longJump
			float longJump = rs.getFloat("longJump");
			if (longJump <= 0.0) {
				continue;
			}
			sportsman.getResults().add(new EventResult(longJump, FieldEvent.LONGJUMP));

			// Set shotPut
			float shotPut = rs.getFloat("shotPut");
			if (shotPut <= 0.0) {
				continue;
			}
			sportsman.getResults().add(new EventResult(shotPut, FieldEvent.SHOTPUT));

			// Set highJump
			float highJump = rs.getFloat("highJump");
			if (highJump <= 0.0) {
				continue;
			}
			sportsman.getResults().add(new EventResult(highJump, FieldEvent.HIGHJUMP));

			// Set sprint400
			float sprint400 = rs.getFloat("sprint400");
			if (sprint400 <= 0.0) {
				continue;
			}
			sportsman.getResults().add(new EventResult(sprint400, TrackEvent.SPRINT400));

			// Set hurdles110
			float hurdles110 = rs.getFloat("hurdles110");
			if (hurdles110 <= 0.0) {
				continue;
			}
			sportsman.getResults().add(new EventResult(hurdles110, TrackEvent.HURDLES110));

			// Set discusThrow
			float discusThrow = rs.getFloat("discusThrow");
			if (discusThrow <= 0.0) {
				continue;
			}
			sportsman.getResults().add(new EventResult(discusThrow, FieldEvent.DISCUSTHROW));

			// Set poleVault
			float poleVault = rs.getFloat("poleVault");
			if (poleVault <= 0.0) {
				continue;
			}
			sportsman.getResults().add(new EventResult(poleVault, FieldEvent.POLEVAULT));

			// Set javelinThrow
			float javelinThrow = rs.getFloat("javelinThrow");
			if (javelinThrow <= 0.0) {
				continue;
			}
			sportsman.getResults().add(new EventResult(javelinThrow, FieldEvent.JAVELINTHROW));

			// Set race1500
			float race1500 = rs.getFloat("race1500");
			if (race1500 <= 0.0) {
				continue;
			}
			sportsman.getResults().add(new EventResult(race1500, TrackEvent.RACE1500));
			sportsmanWithResults.add(sportsman);
		}
	}
}
