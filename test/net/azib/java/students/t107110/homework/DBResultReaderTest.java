package net.azib.java.students.t107110.homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static net.azib.java.students.t107110.homework.Utils.date;
import static net.azib.java.students.t107110.homework.Utils.toInputStream;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shsutrov
 */
public class DBResultReaderTest {
	private static final String DB_URL = "jdbc:hsqldb:mem:db";
	private static final String DB_USER = "sa";
	private static final String DB_PASSWORD = "";
	private static final String DB_PROPERTIES =
			"db.url=" + DB_URL + "\n" + "db.user=" + DB_USER + "\n" + "db.password=" + DB_PASSWORD;

	private static final String UNIQUE_COMPETITION_NAME = "competition-unique";
	private static final String DUPLICATED_COMPETITION_NAME = "competition-duplicated";

	private static final String CREATE_COMPETITIONS = "CREATE TABLE competitions (id INT, name VARCHAR(32))";
	private static final String ADD_COMPETITION = "INSERT INTO competitions (id, name) VALUES (?, ?)";
	private static final String DROP_COMPETITIONS = "DROP TABLE competitions";

	private static final String CREATE_ATHLETES =
			"CREATE TABLE athletes (id INT, name VARCHAR(20), dob DATE, country_code VARCHAR(5))";
	private static final String ADD_ATHLETE = "INSERT INTO athletes (id, name, dob, country_code) VALUES (?, ?, ?, ?)";
	private static final String DROP_ATHLETES = "DROP TABLE athletes";

	private static final String CREATE_RESULTS =
			"CREATE TABLE results (id INT, competition_id INT, athlete_id INT, race_100m FLOAT, long_jump FLOAT, " +
					"shot_put FLOAT, high_jump FLOAT, race_400m FLOAT, hurdles_110m FLOAT, discus_throw FLOAT, " +
					"pole_vault FLOAT , javelin_throw FLOAT , race_1500m FLOAT)";
	private static final String ADD_RESULT =
			"INSERT INTO results (competition_id, athlete_id, race_100m, long_jump, shot_put, high_jump, race_400m, " +
					"hurdles_110m, discus_throw, pole_vault, javelin_throw, race_1500m) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DROP_RESULTS = "DROP TABLE results";

	private Connection connection;
	private ResultReader reader;

	private String name;
	private Date birthDay;
	private String country;
	private double sprint100m;
	private double longJump;
	private double shotPut;
	private double highJump;
	private double sprint400m;
	private double hurdles110m;
	private double discusThrow;
	private double poleVault;
	private double javelinThrow;
	private double race1500m;

	@Before
	public void prepare() throws SQLException, DecathlonException {
		connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		setValues();
		prepareDatabase();
		connection.close();

		reader = new DBResultReader(toInputStream(DB_PROPERTIES), "1");
	}

	@Test
	public void uniqueCompetitionName() throws DecathlonException {
		new DBResultReader(toInputStream(DB_PROPERTIES), UNIQUE_COMPETITION_NAME);
	}

	@Test(expected = DecathlonException.class)
	public void failOnDuplicatedCompetitionName() throws DecathlonException {
		new DBResultReader(toInputStream(DB_PROPERTIES), DUPLICATED_COMPETITION_NAME);
	}

	@Test
	public void readAllOneResult() throws DecathlonException {
		assertThat(reader.read(), is(notNullValue()));
		assertThat(reader.read(), is(nullValue()));
	}

	@Test
	public void athleteName() throws DecathlonException {
		assertThat(reader.read().getAthleteName(), is(name));
	}

	@Test
	public void birthday() throws DecathlonException {
		assertThat(reader.read().getBirthday().getTime(), is(birthDay.getTime()));
	}

	@Test
	public void country() throws DecathlonException {
		assertThat(reader.read().getCountry(), is(country));
	}

	@Test
	public void sprint100m() throws DecathlonException {
		assertThat(reader.read().getSprint100m(), is(sprint100m));
	}

	@Test
	public void longJump() throws DecathlonException {
		assertThat(reader.read().getLongJump(), is(longJump));
	}

	@Test
	public void shotPut() throws DecathlonException {
		assertThat(reader.read().getShotPut(), is(shotPut));
	}

	@Test
	public void highJump() throws DecathlonException {
		assertThat(reader.read().getHighJump(), is(highJump));
	}

	@Test
	public void sprint400m() throws DecathlonException {
		assertThat(reader.read().getSprint400m(), is(sprint400m));
	}

	@Test
	public void hurdles110m() throws DecathlonException {
		assertThat(reader.read().getHurdles110m(), is(hurdles110m));
	}

	@Test
	public void discusThrow() throws DecathlonException {
		assertThat(reader.read().getDiscusThrow(), is(discusThrow));
	}

	@Test
	public void poleVault() throws DecathlonException {
		assertThat(reader.read().getPoleVault(), is(poleVault));
	}

	@Test
	public void javelinThrow() throws DecathlonException {
		assertThat(reader.read().getJavelinThrow(), is(javelinThrow));
	}

	@Test
	public void race1500m() throws DecathlonException {
		assertThat(reader.read().getRace1500m(), is(race1500m));
	}

	@After
	public void clean() throws SQLException {
		reader.close();

		connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		final Statement dropStatement = connection.createStatement();
		dropStatement.execute(DROP_COMPETITIONS);
		dropStatement.execute(DROP_ATHLETES);
		dropStatement.execute(DROP_RESULTS);
		dropStatement.close();
		connection.close();
	}

	private void setValues() {
		name = "Some Athlete";
		birthDay = new Date(date(1973, 5, 21).getTime());
		country = "EU";
		sprint100m = 10.395;
		longJump = 7.76;
		shotPut = 18.4;
		highJump = 2.20;
		sprint400m = 46.17;
		hurdles110m = 13.8;
		discusThrow = 56.17;
		poleVault = 5.28;
		javelinThrow = 77.19;
		race1500m = 233.79;
	}

	private void prepareDatabase() throws SQLException {
		prepareCompetitionTable();
		prepareAthleteTable();
		prepareResultTable();
	}

	private void prepareCompetitionTable() throws SQLException {
		final Statement createStatement = connection.createStatement();
		createStatement.execute(CREATE_COMPETITIONS);
		createStatement.close();

		final PreparedStatement insertStatement = connection.prepareStatement(ADD_COMPETITION);
		insertStatement.setInt(1, 1);
		insertStatement.setString(2, DUPLICATED_COMPETITION_NAME);
		insertStatement.execute();

		insertStatement.setInt(1, 2);
		insertStatement.setString(2, UNIQUE_COMPETITION_NAME);
		insertStatement.execute();

		insertStatement.setInt(1, 3);
		insertStatement.setString(2, DUPLICATED_COMPETITION_NAME);
		insertStatement.execute();
		insertStatement.close();
		insertStatement.close();
	}

	private void prepareAthleteTable() throws SQLException {
		final Statement createStatement = connection.createStatement();
		createStatement.execute(CREATE_ATHLETES);
		createStatement.close();

		final PreparedStatement insertStatement = connection.prepareStatement(ADD_ATHLETE);
		insertStatement.setInt(1, 1);
		insertStatement.setString(2, name);
		insertStatement.setDate(3, birthDay);
		insertStatement.setString(4, country);
		insertStatement.execute();
		insertStatement.close();
	}

	private void prepareResultTable() throws SQLException {
		final Statement createStatement = connection.createStatement();
		createStatement.execute(CREATE_RESULTS);
		createStatement.close();

		final PreparedStatement insertStatement = connection.prepareStatement(ADD_RESULT);
		insertStatement.setInt(1, 1);
		insertStatement.setInt(2, 1);
		insertStatement.setDouble(3, sprint100m);
		insertStatement.setDouble(4, longJump);
		insertStatement.setDouble(5, shotPut);
		insertStatement.setDouble(6, highJump);
		insertStatement.setDouble(7, sprint400m);
		insertStatement.setDouble(8, hurdles110m);
		insertStatement.setDouble(9, discusThrow);
		insertStatement.setDouble(10, poleVault);
		insertStatement.setDouble(11, javelinThrow);
		insertStatement.setDouble(12, race1500m);
		insertStatement.execute();
		insertStatement.close();
	}
}
