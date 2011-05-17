package net.azib.java.students.t092855.homework;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * DecathlonEventsTest
 * Unit tests for {@link net.azib.java.students.t092855.homework.DecathlonEvents}
 *
 * @author t092855
 */
public class DecathlonEventsTest {
	private double[] testResults = {9.58, 8.22, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.00};
	private int[] testPoints = {1202, 1117, 1295, 1244, 1156, 1126, 1383, 1277, 1331, 1218};
	private DecathlonEvents decathlonEvents = new DecathlonEvents(testResults);

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.DecathlonEvents#getDecathlonResults()}
	 */
	@Test
	public void decathlonListIsCorrect() {
		for (int i = 0; i < testResults.length; i++) {
			assertEquals(testResults[i], decathlonEvents.getDecathlonResults()[i], 0.0);
		}
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.DecathlonEvents#getTotalPoints()}
	 */
	@Test
	public void decathlonTotalPointsIsCalculatedCorrectly() {
		int expected = 0;
		for (int testPoint : testPoints) {
			expected += testPoint;
		}
		assertEquals(expected,  decathlonEvents.getTotalPoints());
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.DecathlonEvents#validateAndConvertResult(String)} ()}
	 */
	@Test
	public void resultValidationWorksWithCorrectNumbers() {
		assertEquals(9.58, DecathlonEvents.validateAndConvertResult("9.58"), 0.0);
		assertEquals(10.78, DecathlonEvents.validateAndConvertResult("10.78"), 0.0);
		assertEquals(207.03, DecathlonEvents.validateAndConvertResult("3:27.03"), 0.0);
		assertEquals(207.03, DecathlonEvents.validateAndConvertResult("207.03"), 0.0);
		assertEquals(3.0, DecathlonEvents.validateAndConvertResult("3"), 0.0);
		assertEquals(113.0, DecathlonEvents.validateAndConvertResult("113"), 0.0);
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.DecathlonEvents#validateAndConvertResult(String)} ()}
	 */
	@Test
	public void resultValidationWorksWithIncorrectNumbers() {
		assertEquals(-1.0, DecathlonEvents.validateAndConvertResult("9.58.0"), 0.0);
		assertEquals(-1.0, DecathlonEvents.validateAndConvertResult("10:2:03"), 0.0);
		assertEquals(-1.0, DecathlonEvents.validateAndConvertResult("Text"), 0.0);
		assertEquals(-1.0, DecathlonEvents.validateAndConvertResult("1:1:1"), 0.0);
	}
}
