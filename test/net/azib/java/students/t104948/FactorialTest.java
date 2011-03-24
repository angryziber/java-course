package net.azib.java.students.t104948;

import org.junit.Test;

import java.math.BigInteger;

import static net.azib.java.lessons.basic.FibonacciTest.is;


public class FactorialTest {
	@Test
	public void startsWithZero() {
		assertFactorial(0, is(0));
	}

	@Test
	public void firstFewNumbers() {
		Integer[] expectedValues = {1, 1, 2, 6, 24, 120};
		int index = 0;
		for (Integer expected : expectedValues) {
			assertFactorial(index++, is(expected));
		}

	}

	@Test
	public void someBigNumbers() {
		String[] expectedValues = {"5040", "40320", "362880"};
		int index = 7;
		for (String expected : expectedValues) {
			//TODO create your overload version of doFibonacci. P.S. Do you really want to test Fibonacci in Factorial class? ;)
			//Assert.assertEquals(new BigInteger(expected).toString(), new Fibonacci().doFibonacci(index++));
		}
	}

	private void assertFactorial(int index, BigInteger expected) {
		//TODO create your overload version of doFibonacci.
		//assertThat(new Factorial().doFactorial(index), equalTo(expected.toString()));
	}
}
