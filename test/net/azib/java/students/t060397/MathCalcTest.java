package net.azib.java.students.t060397;

import static org.junit.Assert.*;

import net.azib.java.students.t060397.homework.MathCalc;

import org.junit.Test;

/**
 * MathCalcTest
 *
 * @author marcus
 */
public class MathCalcTest {

	/**
	 * Test method for {@link net.azib.java.students.t060397.homework.MathCalc#distBetweenPoints(int, int, int, int)}.
	 */
	@Test
	public final void testDistBetweenPoints() {
		assertEquals(0, MathCalc.distBetweenPoints(10,10,10,10), 0);
		assertEquals(1, MathCalc.distBetweenPoints(10,0,11,0), 0);
		assertEquals(10, MathCalc.distBetweenPoints(10,10,10,20), 0);
	}
	/**
	 * Test method for {@link net.azib.java.students.t060397.homework.MathCalc#inCircle(int, int, int, int, int)}.
	 */
	@Test
	public final void testInCircle(){
		assertTrue(MathCalc.inCircle(10, 10, 10, 10, 2));
		assertTrue(MathCalc.inCircle(11, 11, 10, 10, 2));
		assertFalse(MathCalc.inCircle(11, 15, 10, 10, 2));
	}
}
