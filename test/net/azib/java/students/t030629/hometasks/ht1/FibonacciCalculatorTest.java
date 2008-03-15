package net.azib.java.students.t030629.hometasks.ht1;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

/**
 * FibonacciCalculatorTest
 *
 * @author anton_chepurov
 */
public class FibonacciCalculatorTest {
	
	@Test
	public void testGetValue(){
		
		assertEquals("0'th Fibonacci number failed", BigInteger.ZERO, new FibonacciCalculator(0).getValue());
		assertEquals("1'st Fibonacci number failed", BigInteger.ONE, new FibonacciCalculator(1).getValue());
		assertEquals("2'nd Fibonacci number failed", BigInteger.ONE, new FibonacciCalculator(2).getValue());
		assertEquals("3'rd Fibonacci number failed", BigInteger.valueOf(2), new FibonacciCalculator(3).getValue());
		assertEquals("4'th Fibonacci number failed", BigInteger.valueOf(3), new FibonacciCalculator(4).getValue());
		assertEquals("10'th Fibonacci number failed", BigInteger.valueOf(55), new FibonacciCalculator(10).getValue());

		try {
			new FibonacciCalculator(-1);
			throw new AssertionError("Fibonacci number for negative index did not fail");
		} catch (IndexOutOfBoundsException e) { /* Test passed */ }
		try {
			new FibonacciCalculator(-50);
			throw new AssertionError("Fibonacci number for negative index did not fail");
		} catch (IndexOutOfBoundsException e) { /* Test passed */ }
		
		int index = 10;
		FibonacciCalculator fc = new FibonacciCalculator(index);
		// Calculate fib. value once
		fc.getValue();
		// Test for consistency
		assertEquals("Fibonacci value is changed during recalculation", BigInteger.valueOf(55), fc.getValue());
		assertEquals("Fibonacci value is changed during recalculation", BigInteger.valueOf(55), fc.getValue());
		assertEquals("Index is changed during the calculation of Fubonacci number", index, fc.getIndex());
		
		
	}
	
	@Test (expected = IndexOutOfBoundsException.class) // IllegalArgumentException.class
	public void testname() throws Exception {
		new FibonacciCalculator(-1);
	}

}
