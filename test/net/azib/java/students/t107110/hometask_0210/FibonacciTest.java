package net.azib.java.students.t107110.hometask_0210;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public class FibonacciTest {
	@Test
	public void fibonacciOfZero() {
		assertThat(fibonacci(0), is("0"));
	}

	@Test
	public void fibonacciOfOne() {
		assertThat(fibonacci(1), is("1"));
	}

	@Test
	public void fibonacciOfTwo() {
		assertThat(fibonacci(2), is("1"));
	}

	@Test
	public void fibonacciOfThree() {
		assertThat(fibonacci(3), is("2"));
	}

	@Test
	public void fibonacciOfFour() {
		assertThat(fibonacci(4), is("3"));
	}

	@Test
	public void fibonacciOfFive() {
		assertThat(fibonacci(5), is("5"));
	}

	@Test
	public void fibonacciOfSix() {
		assertThat(fibonacci(6), is("8"));
	}

	@Test
	public void fibonacciOfTen() {
		assertThat(fibonacci(10), is("55"));
	}

	@Test
	public void fibonacciOfHundred() {
		assertThat(fibonacci(100), is("354224848179261915075"));
	}

	private static String fibonacci(final int n) {
		return new Fibonacci(n).value().toString();
	}
}
