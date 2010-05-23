package net.azib.java.students.t073639;

import net.azib.java.students.t073639.taskAggregation.Square;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * Square
 *
 * @author t073639
 */
public class SquareTest {
	Square s=new Square(5.00);
	@Test
	public void area() throws Exception {
		assertEquals("Area is not 25", 25, s.area(), 0.01); 
	}
	@Test
	public void testHashtableAndEquality() throws Exception {
		Square s1=new Square(5);
		assertEquals(s, s1);
		assertEquals(s.hashCode(), s1.hashCode());
	}
}
