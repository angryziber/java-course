package net.azib.java.students.t020544;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

/**
 * FibonacciTest
 * 
 * @author Julija
 */
public class FibonacciTest {

	/**
	 * @throws java.lang.Exception
	 */
	private Fibonacci f;

	@Before
	public void setUp() throws Exception {
		f = new Fibonacci();
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t020544.Fibonacci#calculateFibonacciNumber(int)}.
	 */
	@Test
	public void testCalculateFibonacciNumber() {

		assertEquals("testCalculateFibonacciNumber(100) failed", "354224848179261915075", f.calculateFibonacciNumber(100)
				.toString());
		assertEquals("testCalculateFibonacciNumber(10) failed", BigInteger.valueOf(55), f.calculateFibonacciNumber(10));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testException() {
		f.calculateFibonacciNumber(-10);
	}
}
