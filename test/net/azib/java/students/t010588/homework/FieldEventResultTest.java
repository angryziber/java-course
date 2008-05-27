package net.azib.java.students.t010588.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests if information has no changes inside of FieldEventResult class and if
 * points are counted correctly for the field event
 *
 * @author Vjatseslav Rosin, 010588
 */
public class FieldEventResultTest {

	private FieldEventResult result;

	@Before
	public void initResult() {
		result = new FieldEventResult(1, 5.32f);
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.FieldEventResult#getValue()}.
	 */
	@Test
	public void testGetValue() {
		assertEquals(5.32, result.getValue(), 0.01);
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.FieldEventResult#getEvent()}.
	 */
	@Test
	public void testGetEvent() {
		assertEquals(EventType.FIELD, result.getEvent());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.FieldEventResult#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals("5.32", result.toString());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.FieldEventResult#getIndex()}.
	 */
	@Test
	public void testGetIndex() {
		assertEquals(1, result.getIndex());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.FieldEventResult#getPoints()}.
	 */
	@Test
	public void testGetPoints() {
		// TODO: check point counting for all 6 field events
		assertEquals(445, result.getPoints());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.FieldEventResult#FieldEventResult(int, float)}.
	 */
	@Test
	public void testFieldEventResult() {
		FieldEventResult fieldEventResult = new FieldEventResult(8, 40.88f);
		assertEquals(8, fieldEventResult.getIndex());
		assertEquals(40.88, fieldEventResult.getValue(), 0.01);
	}
}