package net.azib.java.students.t060401.homework.test;

import net.azib.java.students.t060401.homework.decathlon.PointsCalculator;
import net.azib.java.students.t060401.homework.util.Constants;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * PointsCalculatorTest
 * 
 * @author t060401
 */
public class PointsCalculatorTest {

	@Test
	public void testCalculateRunningEventPoints() throws Exception {

		double points = PointsCalculator.calculatePoints(Constants.SPRINT_100M, 8.9);
		double expected = 1384;
		assertEquals("Incorrect points calculation ", expected, points);
		
		points = PointsCalculator.calculatePoints(Constants.HIGH_JUMP, 0);
		expected = 0;
		assertEquals("Incorrect points calculation ", expected, points);
		
		points = PointsCalculator.calculatePoints(Constants.SHOT_PUT, -9);
		expected = 0;
		assertEquals("Incorrect points calculation ", expected, points);
		
		points = PointsCalculator.calculatePoints(Constants.RACE_1500M, 100.22);
		expected = 2229;
		assertEquals("Incorrect points calculation ", expected, points);
		
		points = PointsCalculator.calculatePoints(Constants.DISCUS_THROW, 17.1234);
		expected = 219;
		assertEquals("Incorrect points calculation ", expected, points);
	}

}
