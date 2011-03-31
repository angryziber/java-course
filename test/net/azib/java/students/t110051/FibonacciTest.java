package net.azib.java.students.t110051;

import net.azib.java.students.t110051.Lesson2.Fibonacci;
import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.Assert.assertEquals;

public class FibonacciTest {

	@Test
	public void fibonacciOfZero(){
		assertEquals("fibonacci failed @ 0", fibonacci(0), BigInteger.valueOf(0));
	}

	@Test
	public void fibonacciOfOne(){
		assertEquals("fibonacci failed @ 1", fibonacci(1), BigInteger.valueOf(1));
	}

	@Test
	public void fibonacciOfTen(){
		assertEquals("fibonacci failed @ 10", fibonacci(10), BigInteger.valueOf(55));
	}

	public static BigInteger fibonacci(int n){
		return new Fibonacci().Computation(n);
	}
}
