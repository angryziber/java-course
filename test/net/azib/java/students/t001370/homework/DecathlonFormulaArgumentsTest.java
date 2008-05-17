package net.azib.java.students.t001370.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * DecathlonFormulaArgumentsTest
 *
 * @author maksim
 */
public class DecathlonFormulaArgumentsTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonFormulaArguments#getRunningEventResult(double)}.
	 */
	@Test
	public void testGetRunningEventResult() {

		assertEquals(DecathlonFormulaArguments.RUNNING_EVENT_100M_IN_SEC.getRunningEventResult(1), 4291);
		assertEquals(DecathlonFormulaArguments.RUNNING_EVENT_400M_IN_SEC.getRunningEventResult(1), 4377);
		assertEquals(DecathlonFormulaArguments.RUNNING_EVENT_110M_HURDLES_IN_SEC.getRunningEventResult(1), 3331);
		assertEquals(DecathlonFormulaArguments.RUNNING_EVENT_1500M_IN_SEC.getRunningEventResult(1), 3425);

	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonFormulaArguments#getFieldEventResult(double)}.
	 */
	@Test
	public void testGetFieldEventResult() {
//		FIELD_EVENT_LONG_JUMP_IN_M 			(0.14354,	220, 	1.40,	100			),
//		FIELD_EVENT_SHOT_PUT_IN_M 			(51.39,		1.5, 	1.05,	1			),
//		FIELD_EVENT_HIGH_JUMP_IN_M			(0.8465,	75, 	1.42,	100			),
//		FIELD_EVENT_DISCUS_THROW_IN_M 		(12.91,		4.0,	1.1,	1			),
//		FIELD_EVENT_POLE_VAULT_IN_M 		(0.2797,	100,	1.35,	100			),
//		FIELD_EVENT_JAVELIN_THROW_IN_M 		(10.14,		7.0,	1.08,	1			),
		assertEquals(DecathlonFormulaArguments.FIELD_EVENT_LONG_JUMP_IN_M.getFieldEventResult(5), 382);
		assertEquals(DecathlonFormulaArguments.FIELD_EVENT_SHOT_PUT_IN_M.getFieldEventResult(5), 191);
		assertEquals(DecathlonFormulaArguments.FIELD_EVENT_HIGH_JUMP_IN_M.getFieldEventResult(1), 81);
		assertEquals(DecathlonFormulaArguments.FIELD_EVENT_DISCUS_THROW_IN_M.getFieldEventResult(5), 12);
		assertEquals(DecathlonFormulaArguments.FIELD_EVENT_POLE_VAULT_IN_M.getFieldEventResult(5), 910);
		assertEquals(DecathlonFormulaArguments.FIELD_EVENT_JAVELIN_THROW_IN_M.getFieldEventResult(25), 230);
		

	}

}
