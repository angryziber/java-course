package net.azib.java.students.t040719.lessons;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CircleTest
 *
 * @author Romi
 */
public class CircleTest {

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Circle#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		Circle c1 = new Circle(5.123409);
		int hash = 1500706212;
		assertEquals(hash, c1.hashCode());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Circle#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Circle c1 = new Circle(13.23243332);
		Circle c2 = new Circle(13.23243332);
		assertEquals(true, c1.equals(c2));
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Circle#toString()}.
	 */
	@Test
	public void testToString() {
		Circle c1 = new Circle(13.23243332);
		String s = "13.23243332";
		assertEquals(s, c1.toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Circle#area()}.
	 */
	@Test
	public void testArea() {
		Circle c = new Circle(5.5);
		System.out.println(c.area());
		double area = 95.03317777109125;
		assertEquals(area, c.area(), 0.00000000000);
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Circle#Circle(double)}.
	 */
	@Test
	public void testCircleDouble() {
		Circle c = new Circle(10.75);
		assertEquals("10.75", c.toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Circle#setRadius(double)}.
	 */
	@Test
	public void testSetRadius() {
		Circle c = new Circle();
		c.setRadius(10.75);
		assertEquals("10.75", c.toString());
	}

}
