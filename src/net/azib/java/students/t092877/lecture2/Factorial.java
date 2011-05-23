package net.azib.java.students.t092877.lecture2;

import java.math.BigInteger;

public class Factorial {

	public BigInteger compute(int N) {

		BigInteger product = null;

		if (N == 1) {

			return product = BigInteger.ONE;
		}
		else {
			product = BigInteger.ONE;
			for (int i = 1; i <= N; i++)
				product = product.multiply(BigInteger.valueOf(i));
		}
		return product;
	}
}
