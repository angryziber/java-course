package net.azib.java.students.t073639.taskAggregation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * CircleTest
 *
 * @author t073639
 */
public class CircleTest {
	Circle c=new Circle(5);
	@Test
	public void area() throws Exception {
		assertEquals(c.area(),5*5*Math.PI,0);
	}
	@Test
	public void hashTableAndEquals() throws Exception {
		Circle c1=new Circle(5);
		assertEquals(c, c1);
		assertEquals(c.hashCode(),c1.hashCode());
	}
}
