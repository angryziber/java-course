package net.azib.java.students.t040750.homework.generic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DecathlonDataTest {

	/**
	 * Test constructor and getters/setters
	 * @throws Exception
	 */
	@Test
	public void testConstructor() throws Exception {
		DecathlonData decathlonData = new DecathlonData(new Athlete(),
				new Result(),9000);
		
		assertEquals(9000, decathlonData.totalPoints);
		assertEquals(null, decathlonData.position);
		
		decathlonData.setTotalPoints(1234);
		decathlonData.setPosition("-");
		
		assertEquals(1234, decathlonData.getTotalPoints());
		assertEquals("-", decathlonData.getPosition());
	}
	
	/**
	 * Test object comparison
	 * @throws Exception
	 */
	@Test
	public void testComparison() throws Exception {
		DecathlonData decathlonData1 = new DecathlonData(new Athlete(),
				new Result(),6000);
		DecathlonData decathlonData2 = new DecathlonData(new Athlete(),
				new Result(),9999);
		DecathlonData decathlonData3 = new DecathlonData(new Athlete(),
				new Result(),0);
		
		assertEquals(-3999, decathlonData1.compareTo(decathlonData2));
		assertEquals(3999, decathlonData2.compareTo(decathlonData1));
		assertEquals(9999, decathlonData2.compareTo(decathlonData3));
	}
	
}
