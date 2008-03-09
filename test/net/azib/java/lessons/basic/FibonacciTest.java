package net.azib.java.lessons.basic;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * FibonacciTest
 *
 * @author anton
 */
public class FibonacciTest {

	@Test
	public void computeGives1() throws Exception {
		Fibonacci fibonacci = new Fibonacci();
		assertEquals("1", fibonacci.compute(1));
		assertEquals("1", fibonacci.compute(2));
	}
	
	@Test
	public void compute3rdNumber() throws Exception {
		Fibonacci fibonacci = new Fibonacci();
		assertEquals("2", fibonacci.compute(3));
	}

}
