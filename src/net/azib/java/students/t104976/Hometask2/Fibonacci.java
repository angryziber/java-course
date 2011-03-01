package net.azib.java.students.t104976.Hometask2;

import java.math.BigInteger;


public class Fibonacci {
	BigInteger a = BigInteger.ONE;
	BigInteger b = BigInteger.ZERO;
	BigInteger c;

	public BigInteger calculateFibonacciNumber(int nr) {
		for (int i = 1; i <= nr; i++) {
			c = a.add(b);
			a = b;
			b = c;
		}
		return c;
	}
}
