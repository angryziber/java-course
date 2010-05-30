package net.azib.java.students.t093052.homework.action.input;

import net.azib.java.students.t093052.homework.Athlete;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import org.junit.Test;

public class DatabaseInputActionTest {
	private static final String[][] ATHLETE_DATA_I = new String[][] {
		{"Siim Susi", "1.01.1976", "EE"},
		{"Beata Kana", "1.01.1980", "ZA"}
	};
	private static final String[][] ATHLETE_RESULTS_I = new String[][] {
		{"12.61", "5.0", "9.22", "1.5", "59.39", "16.43", "21.6", "2.6", "35.81", "325.72"},
		{"13.04", "4.53", "7.79", "1.55", "64.72", "18.74", "24.2", "2.4", "28.2", "410.76"}
	};
	
	private static final String[][] ATHLETE_DATA_II = new String[][] {
		{"József Fenyő", "3.04.1972", "HU"}
	};
	private static final String[][] ATHLETE_RESULTS_II = new String[][] {
		{"10.94", "7.83", "12.48", "2.0", "49.72", "15.67", "38.3", "5.4", "55.84", "271.72"}
	};
	
	private static final Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:hsqldb:mem:TestDB", "sa", "");
	}
	
	private void prepare() throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		stmt.execute("drop table if exists athletes");
		stmt.execute("create table athletes (id integer, name varchar, " +
				"dob date, country_code varchar)");
		stmt.execute("insert into athletes values (1, 'Siim Susi', " +
				"'1976-01-01', 'EE')");
		stmt.execute("insert into athletes values (2, 'Beata Kana', " +
				"'1980-01-01', 'ZA')");
		stmt.execute("insert into athletes values (3, 'József Fenyő', " +
				"'1972-04-03', 'HU')");
		
		stmt.execute("drop table if exists competitions");
		stmt.execute("create table competitions (id integer, country_code " +
				"varchar, date date, name varchar, location varchar)");
		stmt.execute("insert into competitions values (1, 'EE', " +
				"'2005-12-01', 'Training', 'Tallinn')");
		stmt.execute("insert into competitions values (2, 'PL', " +
				"'2006-03-18', 'DECATHLON4BEER', 'Krakow')");
		stmt.execute("insert into competitions values (3, 'EE', " +
				"'2005-12-01', 'Training', 'Tallinn2')");
		
		stmt.execute("drop table if exists results");
		stmt.execute("create table results (id integer, athlete_id " +
			"integer, competition_id integer, race_100m float, " +
			"long_jump float, shot_put float, high_jump float, " +
			"race_400m float, hurdles_110m float, " +
			"discus_throw float, pole_vault float, javelin_throw float, " +
			"race_1500m float)");
		stmt.execute("insert into results values (1, 1, 2, 12.61, 5, 9.22, " +
			"1.5, 59.39, 16.43, 21.6, 2.6, 35.81, 325.72)");
		stmt.execute("insert into results values (2, 2, 2, 13.04, 4.53, 7.79, " +
			"1.55, 64.72, 18.74, 24.2, 2.4, 28.2, 410.76)");
		stmt.execute("insert into results values (1, 3, 1, 10.94, 7.83, 12.48, " +
			"2, 49.72, 15.67, 38.3, 5.4, 55.84, 271.72)");
		
		conn.close();
	}
	
	@Test
	public void testHandleData() throws Exception {
		prepare();
		testHandleData("2", ATHLETE_DATA_I, ATHLETE_RESULTS_I);
		testHandleData("Training", ATHLETE_DATA_II, ATHLETE_RESULTS_II);
	}
	
	private void testHandleData(String value, String[][] personData, 
			String[][] results) throws SQLException, IOException {
		DatabaseInputAction inputAction = createDBInputAction(value);
		
		Set<Athlete> athletes = inputAction.handleData();
		
		assertEquals(personData.length, athletes.size());
		
		int i = 0;
		for (Athlete athlete : athletes) {
			checkAthlete(i++, athlete, personData, results);
		}
	}
	
	private void checkAthlete(int index, Athlete athlete, String[][] personData, 
			String[][] results) {
		assertEquals(personData[index][0], athlete.getName());
		assertEquals(personData[index][1], athlete.getDateOfBirthAsString());
		assertEquals(personData[index][2], athlete.getCountry());
		
		int i = 0;
		for (String value : athlete.getResults().values()) {
			assertEquals(results[index][i++], value);
		}
	}

	private DatabaseInputAction createDBInputAction(String value) {
		return new DatabaseInputAction(value) {
			
			@Override
			Connection openConnection() throws SQLException, IOException {
				return getConnection();
			}
		};
	}
}
