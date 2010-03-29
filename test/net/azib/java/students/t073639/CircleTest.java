package net.azib.java.students.t073639;

import static org.junit.Assert.*;

import net.azib.java.students.t073639.taskAggregation.Circle;

import org.junit.Test;


/**
 * CircleTest
 *
 * @author t073639
 */
public class CircleTest {
	Circle c=new Circle(5);
	@Test
	public void testArea() throws Exception {
		assertTrue("Area error", c.area()==5*5*Math.PI);
	}
	@Test
	public void testHashtableAndEquals() throws Exception {
		Circle c1=new Circle(5);
		assertEquals(c, c1);
		assertTrue(c.hashCode()==c1.hashCode());
	}
}
