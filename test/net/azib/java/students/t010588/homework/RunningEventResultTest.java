package net.azib.java.students.t010588.homework;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests if information has no changes inside of RunningEventResult class and if
 * points are counted correctly for the field event
 *
 * @author Vjatseslav Rosin, 010588
 */
public class RunningEventResultTest {

	private RunningEventResult result;

	@Before
	public void initResult() {
		result = new RunningEventResult(0, 10);
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.RunningEventResult#getValue()}.
	 */
	@Test
	public void testGetValue() {
		assertEquals(10, result.getValue(), 0.01);
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.RunningEventResult#getEvent()}.
	 */
	@Test
	public void testGetEvent() {
		assertEquals(EventType.RUNNING, result.getEvent());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.RunningEventResult#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals("10.00", result.toString());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.RunningEventResult#getIndex()}.
	 */
	@Test
	public void testGetIndex() {
		assertEquals(0, result.getIndex());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.RunningEventResult#getPoints()}.
	 */
	@Test
	public void testGetPoints() {
		assertEquals(1096, result.getPoints());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.RunningEventResult#RunningEventResult(int, float)}.
	 */
	@Test
	public void testRunningEventResult() {
		RunningEventResult result1 = new RunningEventResult(9, 185.87f);
		assertEquals(9, result1.getIndex());
		assertEquals(185.87, result1.getValue(), 0.01);

		RunningEventResult result2 = new RunningEventResult(0, "00:09.89");
		assertEquals(0, result2.getIndex());
		assertEquals(9.89, result2.getValue(), 0.01);
	}
}