package net.azib.java.students.t110051.Lesson2;

import java.math.BigInteger;

public class Factorial {

	public static BigInteger Computation(int n) {

		BigInteger sum = new BigInteger("1");
		BigInteger multiplier = new BigInteger("1");

		if (n == 0) {
			return BigInteger.ONE;
		} else if (n < 0) {
			throw new NumberFormatException();
		} else if (n > 0) {
			for (int i = 1; i < n; i++) {
				multiplier = multiplier.add(BigInteger.ONE);
				sum = sum.multiply(multiplier);
			}
			return sum;
		}
		return null;
	}
}