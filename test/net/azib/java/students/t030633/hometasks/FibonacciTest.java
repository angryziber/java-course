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

	private Fibonacci fib = new Fibonacci();
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.Fibonacci#FibonacciNumber(int)}.
	 */
	@Test
	public void zeroIsZero() {
		assertEquals(0, fib.fibonacciNumber(0));
	}
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.Fibonacci#FibonacciNumber(int)}.
	 */
	@Test
	public void compute5thNumber() {
		assertEquals(5, fib.fibonacciNumber(5));
	}
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.Fibonacci#FibonacciNumber(int)}.
	 */
	@Test
	public void compute100thNumber() {
		BigInteger b = new BigInteger("354224848179261915075");
		assertEquals(b, fib.fibonacciNumber(100));
	}
	
}
