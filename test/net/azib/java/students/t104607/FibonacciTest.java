package net.azib.java.students.t104607;
// @author 104607 IASM

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class FibonacciTest {
	@Test
	public void computeFirst() throws Exception {
		Fibonacci fibonacci = new Fibonacci();
		assertEquals(BigInteger.ZERO,fibonacci.compute(0));
	}

	@Test
	public void computeRandom() throws Exception {
		Fibonacci fibonacci = new Fibonacci();
		assertEquals(BigInteger.valueOf(144),fibonacci.compute(12));
	}
}
