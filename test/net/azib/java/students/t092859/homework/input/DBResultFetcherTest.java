package net.azib.java.students.t092859.homework.input;

import net.azib.java.students.t092859.homework.core.DecathlonResult;
import net.azib.java.students.t092859.homework.core.Event;
import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Map;
import org.junit.Test;

/**
 * DBResultFetcherTest
 *
 * @author konstantin
 */
public class DBResultFetcherTest {
	
	@Test
	public void testFetchResults() throws Exception {
		Connection testDBConnection = DriverManager.getConnection("jdbc:hsqldb:mem:TestDB", "sa", "");
		
		Statement fillStatement = testDBConnection.createStatement();
		fillStatement.execute("create table results (id integer, athlete_id integer, competition_id integer, race_100m float, long_jump float, shot_put float, high_jump float, race_400m float, hurdles_110m float, discus_throw float, pole_vault float, javelin_throw float, race_1500m float)");
		fillStatement.execute("create table athletes (id integer, name varchar(64), dob date, country_code varchar(2))");
		fillStatement.execute("create table competitions (id integer, country_code varchar(2), date date, name varchar(32), location varchar(64))");
		fillStatement.execute("insert into athletes values (1, 'Siim Susi', '1976-01-01', 'EE')");
		fillStatement.execute("insert into competitions values (1, 'EE', '2005-12-01', 'Training', 'Tallinn')");
		fillStatement.execute("insert into results values (1,1,1,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,325.72)");
		testDBConnection.close();
		
		DBResultFetcher uut = new DBResultFetcher("jdbc:hsqldb:mem:TestDB", "sa", "", "1");
		
		DecathlonResult result = uut.fetchResults().get(0);
		assertEquals("Siim Susi", result.getAthlete().getName());
		assertEquals(DateFormat.getDateInstance(DateFormat.SHORT, new Locale("")).parse("01/01/1976"), result.getAthlete().getBirthday());
		assertEquals("EE", result.getAthlete().getCountryLocale().getCountry());
		
		Map<Event, Double> perfomance = result.getPerformance();
		assertEquals((Double)12.61, perfomance.get(Event.SPRINT_100M));
		assertEquals((Double)5.00, perfomance.get(Event.LONG_JUMP));
		assertEquals((Double)9.22, perfomance.get(Event.SHOT_PUT));
		assertEquals((Double)1.50, perfomance.get(Event.HIGH_JUMP));
		assertEquals((Double)59.39, perfomance.get(Event.SPRINT_400M));
		assertEquals((Double)16.43, perfomance.get(Event.HURDLES_110M));
		assertEquals((Double)21.60, perfomance.get(Event.DISCUS_THROW));
		assertEquals((Double)2.60, perfomance.get(Event.POLE_VAULT));
		assertEquals((Double)35.81, perfomance.get(Event.JAVELIN_THROW));
		assertEquals((Double)325.72, perfomance.get(Event.RACE_1500M));
	}
}
