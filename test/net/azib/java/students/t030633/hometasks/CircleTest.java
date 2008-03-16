package net.azib.java.students.t030633.hometasks;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * CircleTest
 * 
 * @author t030633
 */
public class CircleTest {

	/**
	 * Test method for {@link net.azib.java.students.t030633.hometasks.Circle#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		Circle c = new Circle(2);
		assertEquals(2, c.hashCode());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.Circle#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Circle c = new Circle(2);
		Circle c2 = c;
		assertEquals(true, c.equals(c2));
	}

	/**
	 * Test method for {@link net.azib.java.students.t030633.hometasks.Circle#toString()}.
	 */
	@Test
	public void testToString() {
		Circle c = new Circle(2);
		assertEquals("2.0", c.toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t030633.hometasks.Circle#area()}.
	 */
	@Test
	public void testArea() {
		Circle c = new Circle(3);
		assertEquals(28.274333882308138, c.area());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.Circle#setRadius(double)}.
	 */
	@Test
	public void testSetRadius() {
		Circle c = new Circle();
		c.setRadius(2.3);
		assertEquals("2.3",	c.toString()); // depends on toString
	}

}
