package net.azib.java.students.t030633.hometasks;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

/**
 * FibonacciTest
 * 
 * @author t030633
 */
public class FibonacciTest {

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.Fibonacci#FibonacciNumber(int)}.
	 */
	@Test
	public void testFibonacciNumber100() {
		Fibonacci f = new Fibonacci();
		BigInteger b = new BigInteger("354224848179261915075");
		assertEquals(b, f.fibonacciNumber(100));
	}
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.Fibonacci#FibonacciNumber(int)}.
	 */
	@Test
	public void testFibonacciNumber5() {
		Fibonacci f = new Fibonacci();
		BigInteger b = new BigInteger("5");
		assertEquals(b, f.fibonacciNumber(5));
	}

}
