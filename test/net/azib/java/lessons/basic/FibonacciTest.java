package net.azib.java.lessons.basic;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

/**
 * FibonacciTest
 *
 * @author anton
 */
public class FibonacciTest {
	@Test
	public void beginningOfSequence() throws Exception {
		Fibonacci fibonacci = new Fibonacci();
		assertEquals("Should begin with 0", BigInteger.ZERO, fibonacci.compute(0L));
		assertEquals("First two numbers should be 1s", BigInteger.ONE, fibonacci.compute(1L));
		assertEquals("First two numbers should be 1s", BigInteger.ONE, fibonacci.compute(2L));
	}
	
	@Test
	public void tenthNumber() throws Exception {
		Fibonacci fibonacci = new Fibonacci();
		assertEquals(new BigInteger("55"), fibonacci.compute(10L));
	}

	@Test
	public void hundredthNumber() throws Exception {
		Fibonacci fibonacci = new Fibonacci();
		assertEquals(new BigInteger("354224848179261915075"), fibonacci.compute(100L));
	}
}
