package net.azib.java.students.t107110.hometask_0210;

import java.math.BigInteger;

/**
 * @author Eduard Shustrov
 */
public class Factorial {
	private static final BigInteger FACTORIAL_0 = BigInteger.ONE;
	private final BigInteger value;

	public Factorial(final int n) {
		if (n < 0) throw new IllegalArgumentException("Factorials of negative numbers are not supported");

		BigInteger factorial = FACTORIAL_0;
		for (int i = 1; i <= n; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		value = factorial;
	}

	public BigInteger value() {
		return value;
	}
}
