package net.azib.java.students.t001370.lectures.lec1.home;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import net.azib.java.students.t001370.lectures.lec1.Fibonacci;

import org.junit.Test;

/**
 * FibonacciTest
 *
 * @author maksim
 */
public class FibonacciTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec1.Fibonacci#calcFibonacci(int)}.
	 */
	@Test
	public void testCalcFibonacci() {
		Fibonacci fib = new Fibonacci();
		
		assertEquals("!!!Fibonacci has an error!!!", 
				new BigDecimal(55), fib.calcFibonacci(10));
	}

}
