package net.azib.java.students.t092855.homework;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * DecathlonEventTest
 * Unit tests for {@link net.azib.java.students.t092855.homework.DecathlonEvent}
 *
 * @author t092855
 */
public class DecathlonEventTest {
	private final double[] testResults = {9.58, 8.22, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.00};
	private final int[] testPoints = {1202, 1117, 1295, 1244, 1156, 1126, 1383, 1277, 1331, 1218};

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.DecathlonEvent#toString()}
	 */
	@Test
	public void event100MetresNameIsCorrect() {
		assertEquals("100 m", DecathlonEvent.EVENT_100M.toString());
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.DecathlonEvent#calculatePoints(double)}
	 */
		@Test
	public void negativeNumberIsHandled() {
		assertEquals(0, DecathlonEvent.EVENT_100M.calculatePoints(-9.58));
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.DecathlonEvent#calculatePoints(double)}
	 */
	@Test
	public void trackEventIsCalculatedCorrectly() {
		assertEquals(1202, DecathlonEvent.EVENT_100M.calculatePoints(9.58));
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.DecathlonEvent#calculatePoints(double)}
	 */
	@Test
	public void jumpEventIsCalculatedCorrectly() {
		assertEquals(1117, DecathlonEvent.EVENT_LONG_JUMP.calculatePoints(8.22));
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.DecathlonEvent#calculatePoints(double)}
	 */
	@Test
	public void pointsAreCalculatedCorrectly() {
		int i = 0;
		for (DecathlonEvent event : DecathlonEvent.values()) {
			assertEquals(testPoints[i], event.calculatePoints(testResults[i]));
			i++;
		}
	}
}


