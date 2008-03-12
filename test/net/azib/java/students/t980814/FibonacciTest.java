package net.azib.java.students.t980814;

import net.azib.java.students.t980814.lec1.Fibonacci;
import java.math.BigInteger;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * FibonacciTest
 *
 * @author dell
 */
public class FibonacciTest {

	@Test
	public void testFibonacciZero() {
		Fibonacci fib = new Fibonacci(0);
		assertEquals("Fibonacci 0 failed", BigInteger.ZERO, fib.getResult());
		fib.reCalculate(-10);
		assertEquals("Fibonacci -10 failed", BigInteger.ZERO, fib.getResult());
	}
	
	@Test
	public void testFibonacciRecalculation() {
		Fibonacci fib = new Fibonacci(1);
		assertEquals("Fibonacci 1 failed", BigInteger.ONE, fib.getResult());
		fib.reCalculate(5);
		assertEquals("Fibonacci 5 failed", new BigInteger("5"), fib.getResult());
		fib.reCalculate(10);
		assertEquals("Fibonacci 10 failed", new BigInteger("55"), fib.getResult());
	}
	
	@Test
	public void testFibonacciCalcPrev() {
		Fibonacci fib = new Fibonacci(2);
		assertEquals("Fibonacci 2 failed", BigInteger.ONE, fib.getResult());
		fib.calcPrev();
		assertEquals("Fibonacci calcPrev(2) failed", BigInteger.ONE, fib.getResult());
		fib.calcPrev();
		assertEquals("Fibonacci calcPrev(1) failed", BigInteger.ZERO, fib.getResult());
		fib.calcPrev();
		assertEquals("Fibonacci calcPrev(0) failed", BigInteger.ZERO, fib.getResult());
	}

	@Test
	public void testFibonacciCalcNext() {
		Fibonacci fib = new Fibonacci(20);
		fib.calcNext();
		assertEquals("Fibonacci calcNext(20) failed", new BigInteger("10946"), fib.getResult());
	}
}
