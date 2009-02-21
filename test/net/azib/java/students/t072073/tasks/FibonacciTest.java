package net.azib.java.students.t072073.tasks;


import java.math.BigInteger;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * FibonacciTest
 *
 * @author janika
 */
public class FibonacciTest {
	
	@Test
	public void testShouldReturnZero() throws Exception {
        BigInteger result = Fibonacci.calculate(BigInteger.valueOf(0));
        assertEquals(BigInteger.ZERO, result);
	}
	@Test
	public void testShouldReturnOne() throws Exception {
        BigInteger result1 = Fibonacci.calculate(BigInteger.valueOf(1));
        assertEquals(BigInteger.ONE, result1);
        BigInteger result2 = Fibonacci.calculate(BigInteger.valueOf(2));
        assertEquals(BigInteger.ONE, result2);
	}
	
	@Test
	public void testHundred() throws Exception {
        BigInteger result = Fibonacci.calculate(BigInteger.valueOf(100));
        assertEquals("354224848179261915075", result.toString());		
	}

}
