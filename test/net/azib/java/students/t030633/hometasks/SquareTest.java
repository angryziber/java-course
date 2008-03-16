package net.azib.java.students.t030633.hometasks;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * SquareTest
 * 
 * @author t030633
 */
public class SquareTest {

	/**
	 * Test method for {@link net.azib.java.students.t030633.hometasks.Square#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		Square s = new Square(2);
		assertEquals(2, s.hashCode());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.Square#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Square s = new Square(2);
		Square s2 = s;
		assertEquals(true, s.equals(s2));
	}

	/**
	 * Test method for {@link net.azib.java.students.t030633.hometasks.Square#toString()}.
	 */
	@Test
	public void testToString() {
		Square s = new Square(2);
		assertEquals("2.0", s.toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t030633.hometasks.Square#area()}.
	 */
	@Test
	public void testArea() {
		Square s = new Square(3);
		assertEquals(9.0, s.area());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.Square#setSide(double)}.
	 */
	@Test
	public void testSetSide() {
		Square s = new Square();
		s.setSide(2.3);
		assertEquals("2.3", s.toString());
	}

}
