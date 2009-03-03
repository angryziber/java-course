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
	public void verify0() throws Exception {
		assertEquals(BigInteger.ZERO, new Fibonacci().compute(0L));
	}
	
	@Test
	public void verify1and2() throws Exception {
		assertEquals(BigInteger.ONE, new Fibonacci().compute(1L));
		assertEquals(BigInteger.ONE, new Fibonacci().compute(2L));
	}
	
	@Test
	public void verify100() throws Exception {
		assertEquals(new BigInteger("354224848179261915075"), 
				new Fibonacci().compute(100L));
	}
}
