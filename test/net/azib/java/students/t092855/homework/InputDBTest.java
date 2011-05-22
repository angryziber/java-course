package net.azib.java.students.t092855.homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

/**
 * InputDBTest
 * Unit tests for {@link net.azib.java.students.t092855.homework.InputDB}
 *
 * @author t092855
 */
public class InputDBTest {
	private final String demoDBUrl = "jdbc:hsqldb:mem:decathlon";
	private final String demoDBUser = "sa";
	private final String demoDBPassword = "";

	/**
	 * Initialize fake decathlon database for testing.
	 * @throws SQLException database creation fails
	 */
	@Before
	public void initializeFakeDB() throws SQLException {
		Connection connection = DriverManager.getConnection(demoDBUrl, demoDBUser, demoDBPassword);
		Statement statement = connection.createStatement();

		statement.execute("CREATE TABLE athletes (" +
				"id integer, " +
				"name varchar, " +
				"dob date, " +
				"country_code char)");
		statement.execute("INSERT INTO athletes values (" +
				"13, " +
				"'Barry Gibb', " +
				"'1946-09-01', " +
				"'AU')");
		statement.execute("INSERT INTO athletes values (" +
				"8, " +
				"'Erki Nool', " +
				"'1970-06-25', " +
				"'EE')");
		statement.execute("INSERT INTO athletes values (" +
				"3, " +
				"'József Fenyő', " +
				"'1972-04-03', " +
				"'HU')");
		statement.execute("INSERT INTO athletes values (" +
				"12, " +
				"'Tomáš Dvořák', " +
				"'1972-05-11', " +
				"'CZ')");

		statement.execute("CREATE TABLE competitions (" +
				"id integer, " +
				"country_code char, " +
				"date date, " +
				"name varchar, " +
				"location varchar)");
		statement.execute("INSERT INTO competitions values(" +
				"1, " +
				"'EE', " +
				"'2005-12-01', " +
				"'Training', " +
				"'Tallinn')");
		statement.execute("INSERT INTO competitions values (" +
				"2, " +
				"'PL', " +
				"'2006-03-18', " +
				"'DECATHLON4BEER', " +
				"'Krakow')");

		statement.execute("CREATE TABLE results (" +
				"id integer, " +
				"athlete_id integer, " +
				"competition_id integer," +
				"race_100m float, " +
				"long_jump float, " +
				"shot_put float, " +
				"high_jump float, " +
				"race_400m float," +
				"hurdles_110m float, " +
				"discus_throw float, " +
				"pole_vault float, " +
				"javelin_throw float, " +
				"race_1500m float)");
		statement.execute("INSERT INTO results values (3, 3, 2, 13.75, 4.84, 10.12, 1.5, 68.44, " +
				"19.18, 30.85, 2.8, 33.88, 382.75)");
		statement.execute("INSERT INTO results values(8, 8, 2, 10.94, 7.83, 12.48, 2, 49.72, " +
				"15.67, 38.3, 5.4, 55.84, 271.72)");
		statement.execute("INSERT INTO results values(14, 12, 2, 10.62, 8.07, 16.57, 2, 47.74, " +
				"13.8, 45.51, 5, 68.53, 275.13)");
		statement.execute("INSERT INTO results values(15, 13, 2, 12.61, 5, 9.22, 1.2, 59.39, " +
				"16.4, 21.6, 2.6, 35.81, 315.72)");
		statement.execute("INSERT INTO results values(18, 39, 2, 12.61, 5, 9.22, 1.5, 59.39, " +
				"16.43, 21.6, 2.6, 35.81, 325.72)");
	}

	@Test
	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.InputDB#getDataFromDatabase(String, java.util.Properties)}
	 */
	public void getDataFromDatabaseWorks() {
		InputDB inputDB = new InputDB();
		Competition competition = inputDB.getDataFromDatabase("2", getFakeDBProperties());

		Iterator<Athlete> iterator = competition.getCompetitors().iterator();

		Athlete athlete = iterator.next();
		assertEquals("Tomáš Dvořák", athlete.getName());
		assertEquals(8902, athlete.getAthleteEvents().getTotalPoints());

		athlete = iterator.next();
		assertEquals("Erki Nool", athlete.getName());
		assertEquals(8001, athlete.getAthleteEvents().getTotalPoints());

		athlete = iterator.next();
		assertEquals("Barry Gibb", athlete.getName());
		assertEquals(4088, athlete.getAthleteEvents().getTotalPoints());

		athlete = iterator.next();
		assertEquals("József Fenyő", athlete.getName());
		assertEquals(3494, athlete.getAthleteEvents().getTotalPoints());
	}

	/**
	 * Delete fake database
	 * @throws SQLException database is not found.
	 */
	@After
	public void deleteFakeDB() throws SQLException {
		Connection connection = DriverManager.getConnection(demoDBUrl, demoDBUser, demoDBPassword);
		Statement statement = connection.createStatement();
		statement.execute("SHUTDOWN");
		connection.close();
	}

	private Properties getFakeDBProperties() {
		Properties properties = new Properties();
		properties.setProperty("db.url", demoDBUrl);
		properties.setProperty("db.username", demoDBUser);
		properties.setProperty("db.password", demoDBPassword);
		return properties;
	}
}
