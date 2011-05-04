package net.azib.java.students.t092877.lecture2;

import java.math.BigInteger;

public class Factorial {

	public BigInteger compute(int N) {

		BigInteger product = BigInteger.ONE;

		if (N == 0) {
			return product;
		}
		else {
			for (int i = 1; i <= N; i++)
				product = product.multiply(BigInteger.valueOf(i));
		}

		return product;
	}
}
