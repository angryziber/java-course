package net.azib.java.students.t060397.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * MathCalcTest
 *
 * @author Margus Ernits
 */
public class MathCalcTest {

	/**
	 * Test method for {@link net.azib.java.students.t060397.homework.MathCalc#distBetweenPoints(int, int, int, int)}.
	 */
	@Test
	public final void testDistBetweenPoints() {
		assertEquals(0, MathCalc.distBetweenPoints(140, 222, 140, 222), 0);
		assertEquals(0, MathCalc.distBetweenPoints(0, -777, 0, -776), 1);
		assertEquals(0, MathCalc.distBetweenPoints(0, 0, 0, 0), 0);
		
	}

	/**
	 * Test method for {@link net.azib.java.students.t060397.homework.MathCalc#inCircle(int, int, int, int, int)}.
	 */
	@Test
	public final void testInCircle() {
		assertTrue(MathCalc.inCircle(200, 150, 300, 300, 200));
		assertTrue(MathCalc.inCircle(200, 200, 201, 201, 2));
		assertFalse(MathCalc.inCircle(200, 200, 203, 201, 2));
	}

	/**
	 * Test method for {@link net.azib.java.students.t060397.homework.MathCalc#getRumb(int)}.
	 */
	@Test
	public final void testGetRumb() {
		assertEquals(MathCalc.getRumb(90),MathCalc.Rumb.N);
		assertEquals(MathCalc.getRumb(137), MathCalc.Rumb.NW);
		assertEquals(MathCalc.getRumb(185), MathCalc.Rumb.W);
		assertEquals(MathCalc.getRumb(225), MathCalc.Rumb.SW);
		assertEquals(MathCalc.getRumb(280), MathCalc.Rumb.S);
		assertEquals(MathCalc.getRumb(294), MathCalc.Rumb.SO);
		assertEquals(MathCalc.getRumb(0), MathCalc.Rumb.O);
		assertEquals(MathCalc.getRumb(44), MathCalc.Rumb.NO);
		
	}

}
