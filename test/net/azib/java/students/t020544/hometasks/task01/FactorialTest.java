package net.azib.java.students.t020544.hometasks.task01;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * FactorialTest
 *
 * @author Julija Kondratjeva
 */
public class FactorialTest {

	/**
	 * Test method for {@link net.azib.java.students.t020544.hometasks.task01.Factorial#calculateFactorial(int)}.
	 */
	
	Factorial f = new Factorial();
	
	@Test(expected=IllegalArgumentException.class)
	public void expectedExeption() throws Exception {
		f.calculateFactorial(-1);
	}
	@Test public void clculateFactorial0() throws Exception {
		assertEquals(1, f.calculateFactorial(0));
	}
	
	@Test public void clculateFactorial10() throws Exception {
		assertEquals(3628800, f.calculateFactorial(10));
	}
	



}
