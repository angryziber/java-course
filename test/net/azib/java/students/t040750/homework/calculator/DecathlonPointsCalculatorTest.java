package net.azib.java.students.t040750.homework.calculator;

import static org.junit.Assert.assertEquals;

import net.azib.java.students.t040750.homework.generic.Result;

import org.junit.Test;

public class DecathlonPointsCalculatorTest {

	/**
	 * Test total points calculator on valid values.
	 * @throws Exception
	 */
	@Test
	public void testTotalPoints() throws Exception {
		Result result = new Result();
		
		result.setRun100m(10.94f);
		result.setLongJump(7.83f);
		result.setShotPut(12.48f);
		result.setHighJump(2.0f);
		result.setRun400m(49.72f);
		result.setHurdles110m(15.67f);
		result.setDiscus(38.3f);
		result.setPoleVault(5.4f);
		result.setJavelin(55.84f);
		result.setRun1500m(271.72f);
		
		assertEquals(8001, DecathlonPointsCalculator.calculateTotalPoints(result));
	}
	
	/**
	 * Test total points calculator on zero values.
	 * @throws Exception
	 */
	@Test
	public void testTotalPointsZeroes() throws Exception {
		Result result = new Result();
		
		assertEquals(0, DecathlonPointsCalculator.calculateTotalPoints(result));
	}
}
