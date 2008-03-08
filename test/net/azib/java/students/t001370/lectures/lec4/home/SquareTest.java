package net.azib.java.students.t001370.lectures.lec4.home;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * SquareTest
 *
 * @author maksim
 */
public class SquareTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec4.home.Square#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		Square c = new Square(3);
		assertEquals("!!!Square hashCode failed!!!",
				c.getEdgeLenght(), c.hashCode());
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec4.home.Square#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Square a = new Square(10);
		Square b = new Square(10);
		Square c = new Square(11);
		
		assertEquals("!!!Square equals assertEquals failed!!!", a.equals(b), b.equals(a));
		assertFalse("!!!Square equals assertFalse failed!!!", a.equals(c));
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec4.home.Square#area()}.
	 */
	@Test
	public void testArea() {
		assertEquals("!!!Square area failed!!!",
				new Square(5).area(), 25);
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec4.home.Square#getEdgeLenght()}.
	 */
	@Test
	public void testGetEdgeLenght() {
		assertEquals("!!!Square gerEdgeLenght failed!!!",
				new Square(9).getEdgeLenght(), 9);
	}

}
