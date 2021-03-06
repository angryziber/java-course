package net.azib.java.students.t104948;

import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;

import static net.azib.java.lessons.basic.FibonacciTest.is;

public class FibonacciTest {
	@Test
	public void startsWithZero() {
		assertFibonacci(0, is(0));
	}

	@Test @Ignore
	public void firstFewNumbers() {
		int[] expectedValues = {0, 1, 1, 2, 3, 5, 8, 13, 21};
		int index = 0;
		for (Integer expected : expectedValues) {
			assertFibonacci(index++, is(expected));
		}

	}

	@Test @Ignore
	public void someBigNumbers() {
		String[] expectedValues = {"6765", "10946", "17711", "28657", "46368", "75025", "121393", "196418"};
		int index = 20;
		for (String expected : expectedValues) {
			//TODO create your overload version of doFibonacci
			//assertEquals(new BigInteger(expected).toString(), new Fibonacci().doFibonacci(index++));
		}
	}

	private void assertFibonacci(int index, BigInteger expected) {
		//TODO create your overload version of doFibonacci !!!
		//assertThat(new Fibonacci().doFibonacci(index), equalTo(expected.toString()));
	}


}
