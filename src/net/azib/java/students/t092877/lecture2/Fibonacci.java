package net.azib.java.students.t092877.lecture2;

import java.math.BigInteger;

public class Fibonacci {

	public BigInteger compute(int N) {

		BigInteger f0 = BigInteger.ZERO;
		BigInteger f1 = BigInteger.ONE;

		if (N == 1)
			return f0;
		else if (N == 2)
			return f1;
		else {

			for (int i = 2; i <= N; i++) {

				BigInteger fi = f0.add(f1);

				f0 = f1;
				f1 = fi;
			}
		}

		return f1;
	}
}