package net.azib.java.students.t092859.homework.input;

import static org.junit.Assert.*;

import net.azib.java.students.t092859.homework.core.DecathlonResult;
import net.azib.java.students.t092859.homework.core.Event;

import java.io.StringReader;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;

/**
 * CSVResultFetcherTest
 *
 * @author konstantin
 */
public class CSVResultFetcherTest {

	@Test
	public void testFetchResults() throws Exception {
		
		String testData = "\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72"; 
		
		CSVResultFetcher uut = new CSVResultFetcher(new StringReader(testData));
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
