package net.azib.java.students.t092859.homework.core;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.Map;

import org.junit.Test;

/**
 * DecathlonResultTest
 *
 * @author konstantin
 */
public class DecathlonResultTest {
	
	@Test
	public void testDecathlonResultConstructionGood() throws Exception {
		String[] parameters = {"Jaan Toe","01.01.1980","EE","12.61","5.00","9.22",
				"1.50","59.39","16.43","21.60","2.60","35.81","5:25.72"};
		DecathlonResult result = new DecathlonResult(parameters);
		assertEquals(-1, result.getValidationResult());
		assertEquals(parameters[0], result.getAthlete().getName());
		assertEquals(new GregorianCalendar(1980, 0, 1).getTime(), result.getAthlete().getBirthday());
		assertEquals(parameters[2], result.getAthlete().getCountryLocale().getCountry());
		
		Map<Event, Double> performance = result.getPerformance();
		for(int i = 3; i < 13; i++)	{
			Event event = Event.values()[i-3];
			assertEquals(parameters[i], event.formatResult(performance.get(event)));
		}
	}

	@Test
	public void testDecathlonResultConstructionBadPattern() throws Exception {
		String[] parameters = {"Jaan Toe","01.01.1980","EE","12!61","5.00","9.22",
				"1.50","59.39","16.43","21.60","2.60","35.81","5:25.72"};
		DecathlonResult result = new DecathlonResult(parameters);
		assertEquals(3, result.getValidationResult());
	}

	@Test
	public void testDecathlonResultConstructionBadDate() throws Exception {
		String[] parameters = {"Jaan Toe","01/01/1001","EE","12.61","5.00","9.22",
				"1.50","59.39","16.43","21.60","2.60","35.81","5:25.72"};
		DecathlonResult result = new DecathlonResult(parameters);
		assertEquals(1, result.getValidationResult());
	}
	
	@Test
	public void testGetPoints() throws Exception {
		String[] parameters = {"Jaan Toe","01.01.1980","EE","12.61","5.00","9.22",
				"1.50","59.39","16.43","21.60","2.60","35.81","5:25.72"};
		DecathlonResult result = new DecathlonResult(parameters);
		assertEquals(4234, result.getPoints());
	}
}
