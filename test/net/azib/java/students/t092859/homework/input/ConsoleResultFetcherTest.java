package net.azib.java.students.t092859.homework.input;

import net.azib.java.students.t092859.homework.core.DecathlonResult;
import net.azib.java.students.t092859.homework.core.Event;
import static org.junit.Assert.*;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Map;
import org.junit.Test;

/**
 * ConsoleResultFetcherTest
 *
 * @author konstantin
 */
public class ConsoleResultFetcherTest {
	
	@Test
	public void testResultFetch() throws Exception {
		ConsoleResultFetcher uut = new ConsoleResultFetcher(); //unit under test
		
		String testInput = "Siim Susi\n" +
		"01.01.1976\n" +
		"EE\n" +
		"12.61\n" +
		"5.00\n" +
		"9.22\n" +
		"1.50\n" +
		"59.39\n" +
		"16.43\n" +
		"21.60\n" +
		"2.60\n" +
		"35.81\n" +
		"5:25.72\n" +
		"n\n";
		
		uut.setTestInput(testInput);
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
