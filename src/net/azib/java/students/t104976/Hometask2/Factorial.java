package net.azib.java.students.t104976.Hometask2;


import java.math.BigInteger;

public class Factorial {

	public BigInteger calculateFactorial(int nr) {
		BigInteger a = BigInteger.ONE;
		for (int i = 1; i <= nr; i++) {
			a = a.multiply(BigInteger.valueOf(i));
		}
		return a;
	}


}
