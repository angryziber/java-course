package net.azib.java.students.t107110.hometask_0210;

import java.math.BigInteger;

/**
 * @author Eduard Shustrov
 */
public class Fibonacci {
	private static final BigInteger FIBONACCI_0 = BigInteger.ZERO;
	private static final BigInteger FIBONACCI_1 = BigInteger.ONE;

	private final BigInteger value;

	public Fibonacci(final int n) {
		if (n < 0) throw new IllegalArgumentException("Negative Fibonacci numbers are not supported");

		if (n == 0) {
			value = FIBONACCI_0;
			return;
		}
		if (n == 1) {
			value = FIBONACCI_1;
			return;
		}

		BigInteger fibonacci_i_minus_2 = FIBONACCI_0;
		BigInteger fibonacci_i_minus_1 = FIBONACCI_1;
		BigInteger fibonacci_i = null;
		for (int i = 2; i <= n; i++) {
			fibonacci_i = fibonacci_i_minus_1.add(fibonacci_i_minus_2);
			fibonacci_i_minus_2 = fibonacci_i_minus_1;
			fibonacci_i_minus_1 = fibonacci_i;
		}
		value = fibonacci_i;
	}

	public BigInteger value() {
		return value;
	}
}
