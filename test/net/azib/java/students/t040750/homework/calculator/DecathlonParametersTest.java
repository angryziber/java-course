package net.azib.java.students.t040750.homework.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DecathlonParametersTest {

	/**
	 * Test the calculations on valid values.
	 * @throws Exception
	 */
	@Test
	public void testValidCalculations() throws Exception {
		assertEquals(536, DecathlonParameters.RUN_100M.trackPoints(12.61f));
		assertEquals(382, DecathlonParameters.LONG_JUMP.fieldPoints(5.0f*100));
		assertEquals(439, DecathlonParameters.SHOT_PUT.fieldPoints(9.22f));
		assertEquals(389, DecathlonParameters.HIGH_JUMP.fieldPoints(1.5f*100));
		assertEquals(434, DecathlonParameters.RUN_400M.trackPoints(59.39f));
		assertEquals(685, DecathlonParameters.HURDLES_110M.trackPoints(16.43f));
		assertEquals(302, DecathlonParameters.DISCUS.fieldPoints(21.6f));
		assertEquals(264, DecathlonParameters.POLE_VAULT.fieldPoints(2.6f*100));
		assertEquals(382, DecathlonParameters.JAVELIN.fieldPoints(35.81f));
		assertEquals(421, DecathlonParameters.RUN_1500M.trackPoints(325.72f));
	}
	
	/**
	 * Test the calculations on zero values.
	 * @throws Exception
	 */
	@Test
	public void testZeroCalculations() throws Exception {
		assertEquals(0, DecathlonParameters.RUN_100M.trackPoints(0f));
		assertEquals(0, DecathlonParameters.LONG_JUMP.fieldPoints(0f));
		assertEquals(0, DecathlonParameters.SHOT_PUT.fieldPoints(0f));
		assertEquals(0, DecathlonParameters.HIGH_JUMP.fieldPoints(0f));
		assertEquals(0, DecathlonParameters.RUN_400M.trackPoints(0f));
		assertEquals(0, DecathlonParameters.HURDLES_110M.trackPoints(0f));
		assertEquals(0, DecathlonParameters.DISCUS.fieldPoints(0f));
		assertEquals(0, DecathlonParameters.POLE_VAULT.fieldPoints(0f));
		assertEquals(0, DecathlonParameters.JAVELIN.fieldPoints(0f));
		assertEquals(0, DecathlonParameters.RUN_1500M.trackPoints(0f));
	}
}
