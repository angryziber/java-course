package net.azib.java.students.t072073.tasks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * SquareTest
 *
 * @author janika
 */
public class SquareTest {
	@Test
	public void testShouldReturnArea() throws Exception {
		double testWidth = 20;
		Square round = new Square(testWidth);
		double testResult = Math.pow(testWidth, 2);
		assertEquals(testResult, round.area());
	}
	@Test
	public void testShouldEqual() throws Exception {
		Square firstSquare = new Square(10);
		Square secondSquare = new Square(10);
		assertEquals(true, firstSquare.equals(secondSquare));
	}
	@Test
	public void testShouldNotEqual() throws Exception {
		Square firstSquare = new Square(10);
		Square secondSquare = new Square(15);
		assertEquals(false, firstSquare.equals(secondSquare));
	}

	@Test
	public void testToString() throws Exception {
		Square square = new Square(10);
		assertEquals("Square with width 10.0", square.toString());
	}
	
	@Test
	public void testHashCode() throws Exception {
		Square square = new Square(10);
		int expectedValue = new Double(square.area()).intValue();
		assertEquals(expectedValue, square.hashCode());
	}
	
	@Test
	public void testReturnWidth() throws Exception {
		Square square = new Square(10);
		assertEquals(10, square.getWidth());
	}
}
