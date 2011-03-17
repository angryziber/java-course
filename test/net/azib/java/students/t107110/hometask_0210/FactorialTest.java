package net.azib.java.students.t107110.hometask_0210;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public class FactorialTest {
	@Test
	public void factorialOfZero() {
		assertThat(factorial(0), is("1"));
	}

	@Test
	public void factorialOfOne() {
		assertThat(factorial(1), is("1"));
	}

	@Test
	public void factorialOfTwo() {
		assertThat(factorial(2), is("2"));
	}

	@Test
	public void factorialOfThree() {
		assertThat(factorial(3), is("6"));
	}

	@Test
	public void factorialOfTen() {
		assertThat(factorial(10), is("3628800"));
	}

	@Test
	public void factorialOfHundred() {
		assertThat(factorial(100), is("933262154439441526816992388562667004907159682643816214685929638952175999932299" +
				"15608941463976156518286253697920827223758251185210916864000000000000000000000000"));
	}

	private static String factorial(final int n) {
		return new Factorial(n).value().toString();
	}
}
