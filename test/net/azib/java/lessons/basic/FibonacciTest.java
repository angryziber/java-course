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
	
	public static void main(String[] args) {
		// test that beginning of fibonacci sequence is 0, 1, 1
		Fibonacci fibonacci = new Fibonacci();
		assert fibonacci.compute(0L).equals(BigInteger.ZERO) : "Should begin with 0";
		assert fibonacci.compute(1L).equals(BigInteger.ONE) : "First two numbers should be 1s";
		assert fibonacci.compute(2L).equals(BigInteger.ONE) : "First two numbers should be 1s";
		System.out.println("OK");
	}
}
