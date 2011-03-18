package net.azib.java.lessons.basic;

import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FibonacciTest {

	@Test
	public void startsWithZero() {
		assertFibonacci(0, is(0));
	}

	@Test
	public void firstFewNumbers() {
		assertFibonacciSequence(0, 1, 1, 2, 3, 5, 8, 13);
	}

	private void assertFibonacciSequence(int ... numbers) {
		int i = 0;
		for (int n : numbers) {
			assertFibonacci(i++, is(n));
		}
	}

	public static BigInteger is(int value) {
		return BigInteger.valueOf(value);
	}

	private void assertFibonacci(int index, BigInteger expected) {
		assertThat(new Fibonacci().compute(index), equalTo(expected));
	}
}
