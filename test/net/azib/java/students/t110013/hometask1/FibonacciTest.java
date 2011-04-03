package net.azib.java.students.t110013.hometask1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vadim
 */
public class FibonacciTest {

	@Test(expected = IllegalArgumentException.class)
	public void negativeFibonacciNumbersAreNotSupported() {
		fibonacci(-1);
	}

	@Test
	public void firstFewFibonacciNumbers() {
		assertFibonacciSequence("0", "1", "1", "2", "3", "5", "8", "13");
	}

	@Test
	public void fibonacciNumberOfHundred() {
		assertThat(fibonacci(100), is("354224848179261915075"));
	}

	private String fibonacci(int n) {
		return Fibonacci.compute(n).toString();
	}

	private void assertFibonacciSequence(String... numbers) {
		int i = 0;
		for (String n : numbers) {
			assertThat(fibonacci(i++), is(n));
		}
	}
}
