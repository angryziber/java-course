package net.azib.java.students.t092855;


import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

	@Test
	public void firstNumberIsCorrect() {
		assertEquals(BigInteger.ZERO, new Fibonacci().getNumber(1));
	}

	@Test
	public void secondNumberIsCorrect() {
		assertEquals(BigInteger.ONE, new Fibonacci().getNumber(2));
	}

	@Test
	public void firstFewNumbersAreCorrect() {
		assertFibonacciSequence(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144);
	}

	private void assertFibonacciSequence(int ... numbers) {
		for(int i = 1; i < numbers.length; i++) {
			assertFibonacci(BigInteger.valueOf(numbers[i - 1]), i);
		}
	}

	private void assertFibonacci(BigInteger expected, int index) {
		assertEquals(expected, new Fibonacci().getNumber(index));
	}
}

