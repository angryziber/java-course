package net.azib.java.students.t073639.taskAggregation;

import static org.junit.Assert.*;

import net.azib.java.students.t073639.taskAggregation.Square;

import org.junit.Test;


/**
 * SquareTest
 *
 * @author t073639
 */
public class SquareTest {
	Square s=new Square(5.00);
	@Test
	public void area() throws Exception {
		assertEquals("Area is not 25", s.area(),25,0); 
	}
	@Test
	public void hashTableAndEquality() throws Exception {
		Square s1=new Square(5);
		assertEquals(s, s1);
		assertEquals(s.hashCode(),s1.hashCode());
	}
}
