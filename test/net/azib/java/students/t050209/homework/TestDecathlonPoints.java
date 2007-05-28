package net.azib.java.students.t050209.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * TestDecathlonPoints
 *
 * @author kaupo
 */
public class TestDecathlonPoints {
	
	@Test
	/**
	 * Checks if 100 meters result is calculated correctly
	 * @throws Exception
	 */
	public void testRunningEventPoints() throws Exception {
		int result = DecathlonPoints.values()[0].runningEventsPoints(9.9);
		assertEquals("Assert failed. Not Equal", 1123 , result);
	}

	
	@Test
	/**
	 * Checks if high jump result is calculated correctly
	 * @throws Exception
	 */
	public void testFieldEventPoints() throws Exception {
		int result = DecathlonPoints.values()[3].fieldEventsPoints(2.13);
		assertEquals("Assert failed. Not Equal", 925 , result);		
	}
	
	@Test
	/**
	 * Checks if current event is field event or not.
	 * #0 is 100 meters run, #3 is high jump
	 * @throws Exception
	 */
	public void testCheckIfRunningEvent() throws Exception {
		assertEquals("Assert failed. Not Equal", true , DecathlonPoints.values()[0].checkIfRunningEvent());
		assertEquals("Assert failed. Not Equal", false , DecathlonPoints.values()[3].checkIfRunningEvent());
	}
}
