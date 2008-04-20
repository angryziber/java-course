package net.azib.java.students.t072054.hometask1;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

/**
 * FibonacciTest
 * 
 * @author Roman
 */
public class FibonacciTest {

	/**
	 * Test method for {@link net.azib.java.students.t072054.Fibonacci}.
	 */
	@Test
	public void testCalculateFib() {
		BigInteger bigInt = new BigInteger("3082418197812910491");
		Fibonacci f = new Fibonacci();
		assertEquals(bigInt, f.calculateFib(111));
	}

}
