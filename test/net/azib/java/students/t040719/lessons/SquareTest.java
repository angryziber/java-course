package net.azib.java.students.t040719.lessons;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * SquareTest
 *
 * @author Romi
 */
public class SquareTest {

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Square#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		Square sq = new Square(5.123409);
		int hash = 1500706212;
		assertEquals(hash, sq.hashCode());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Square#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Square sq1 = new Square(13.23243332);
		Square sq2 = new Square(13.23243332);
		assertEquals(true, sq1.equals(sq2));
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Square#toString()}.
	 */
	@Test
	public void testToString() {
		Square sq = new Square(13.23243332);
		String s = "13.23243332";
		assertEquals(s, sq.toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Square#area()}.
	 */
	@Test
	public void testArea() {
		Square sq = new Square(5.5);
		double area = 30.25;
		assertEquals(area, sq.area(), 0.00000000000);
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Square#Square(double)}.
	 */
	@Test
	public void testSquareDouble() {
		Square sq = new Square(10.192);
		assertEquals("10.192", sq.toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Square#setSide(double)}.
	 */
	@Test
	public void testSetSide() {
		Square sq = new Square();
		sq.setSide(10.119);
		assertEquals("10.119", sq.toString());
	}

}
