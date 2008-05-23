package net.azib.java.students.t030633.homework.view.in;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.Event;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * DatabaseTest
 * 
 * @author t030633
 */
public class DatabaseTest {

	private static Connection getTestConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:hsqldb:mem:dec", "sa", "");
	}

	@BeforeClass
	public static void setUpTestDatabase() throws SQLException {
		Connection conn = getTestConnection();
		Statement stmt = conn.createStatement();

		stmt.execute("create table athletes (id integer, name varchar, dob date, country_code varchar)");
		stmt.execute("insert into athletes values (1, 'Test Man', '1998-07-08', 'EE')");

		stmt.execute("create table competitions (id integer, country_code varchar, date date, name varchar, location varchar)");
		stmt.execute("insert into competitions values (1, 'UK', '2001-02-03', 'Test Comp', 'Memory')");

		stmt.execute("create table results (id integer, athlete_id integer, competition_id integer, "
				+ "race_100m float, long_jump float, shot_put float, high_jump float, race_400m float, "
				+ "hurdles_110m float, discus_throw float, pole_vault float, javelin_throw float, race_1500m float)");
		stmt.execute("insert into results values(1, 1, 1, 15, 2, 2, 2, 15, 15, 2, 2, 2, 200)");

		conn.close();
	}

	@Test
	public void canGetAthleteByCompetitionNumber() throws SQLException, IOException {
		Input input = new Database(getTestConnection());
		List<Athlete> athletes = input.read("1");
		assertEquals(1, athletes.size());
		assertEquals(15, athletes.get(0).getResults().get(Event.R100M));
	}
	
	@Test
	public void canGetAthleteByCompetitionName() throws SQLException, IOException {
		Input input = new Database(getTestConnection());
		List<Athlete> athletes = input.read("Test Comp");
		assertEquals(1, athletes.size());
		assertEquals("Test Man", athletes.get(0).getName());
	}
	
	@Test
	public void criterionNotSpecifiedExceptionIsThrown() throws SQLException {
		Input input = new Database(getTestConnection());
		try {
			input.read();
		}
		catch (IOException e) {
			assertEquals("Competition name or number not specified.", e.getMessage());
		}
	}

}
