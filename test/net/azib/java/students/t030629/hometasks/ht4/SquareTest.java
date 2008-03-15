package net.azib.java.students.t030629.hometasks.ht4;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * SquareTest
 *
 * @author anton_chepurov
 */
public class SquareTest {

	@Test
	public void testAreaPrecision(){
		assertCorrectPrecision(4.00000, new Square(2).area());
	}
	
	private void assertCorrectPrecision(double expected, double actual){
		double difference = actual - expected;
		assertTrue(Math.abs(difference) <= 0.00001);
	}
	
	@Test
	public void testToString(){
		assertEquals("Square with side 2.0", new Square(2).toString());
	}
	
}
