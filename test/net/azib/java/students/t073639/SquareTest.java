package net.azib.java.students.t073639;

import static org.junit.Assert.*;

import net.azib.java.students.t073639.taskAggregation.Square;

import org.junit.Test;


/**
 * Square
 *
 * @author t073639
 */
public class SquareTest {
	Square s=new Square(5.00);
	@Test
	public void testArea() throws Exception {
		assertTrue("Area is not 25", s.area()==25); 
	}
	@Test
	public void testHashtableAndEquality() throws Exception {
		Square s1=new Square(5);
		assertEquals(s, s1);
		assertTrue(s.hashCode()==s1.hashCode());
	}
}
