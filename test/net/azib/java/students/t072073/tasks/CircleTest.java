package net.azib.java.students.t072073.tasks;

import static org.junit.Assert.*;
import org.junit.Test;
/**
 * CircleTest
 *
 * @author janika
 */
public class CircleTest {
	@Test
	public void testShouldReturnArea() throws Exception {
		double testRadius = 20;
		Circle round = new Circle(testRadius);
		double testResult = (Math.pow(testRadius, 2)*Math.PI)/2;
		assertEquals(testResult, round.area());
	}
	@Test
	public void testShouldEqual() throws Exception {
		Circle firstCircle = new Circle(10);
		Circle secondCircle = new Circle(10);
		assertEquals(true, firstCircle.equals(secondCircle));
	}
	@Test
	public void testShouldNotEqual() throws Exception {
		Circle firstCircle = new Circle(10);
		Circle secondCircle = new Circle(15);
		assertEquals(false, firstCircle.equals(secondCircle));
	}

	@Test
	public void testToString() throws Exception {
		Circle circle = new Circle(10);
		assertEquals("Circle with radius 10.0", circle.toString());
	}
	
	@Test
	public void testHashCode() throws Exception {
		Circle circle = new Circle(10);
		int expectedResult = new Double(circle.area()).intValue();
		assertEquals(expectedResult, circle.hashCode());
	}
	
	@Test
	public void testReturnRadius() throws Exception {
		Circle circle = new Circle(10);
		assertEquals(10, circle.getRadius());
	}
}
