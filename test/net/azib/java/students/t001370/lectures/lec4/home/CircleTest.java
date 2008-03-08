package net.azib.java.students.t001370.lectures.lec4.home;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CircleTest
 *
 * @author maksim
 */
public class CircleTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec4.home.Circle#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		Circle c = new Circle(3);
		assertEquals("!!!Circle hashCode failed!!!",
				c.getRadius(), c.hashCode());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec4.home.Circle#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Circle a = new Circle(10);
		Circle b = new Circle(10);
		Circle c = new Circle(11);
		
		assertEquals("!!!Circle equals assertEquals failed!!!", a.equals(b), b.equals(a));
		assertFalse("!!!Circle equals assertFalse failed!!!", a.equals(c));
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec4.home.Circle#area()}.
	 */
	@Test
	public void testArea() {
		assertEquals("!!!Circle area failed!!!", 
				(new Circle(0).PI)*4*4, new Circle(4).area());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec4.home.Circle#getRadius()}.
	 */
	@Test
	public void testGetRadius() {
		assertEquals("!!!Circle getRadius failed!!!", 
				4, new Circle(4).getRadius());
	}

}
