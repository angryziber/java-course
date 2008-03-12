package net.azib.java.students.t980814.lec1;

import java.math.BigInteger;

/**
 * Factorial
 * 
 * @author allan
 */
public class Factorial {

	BigInteger fact;
	int n;

	public Factorial(int n) {
		BigInteger multiplier = new BigInteger("1");

		if (n < 0)
			n = 0;

		fact = BigInteger.ONE;
		this.n = n;
		for (int i = 0; i < n; i++) {
			fact = fact.multiply(multiplier);
			multiplier = multiplier.add(BigInteger.ONE);
		}
	}

	public BigInteger getResult() {
		return fact;
	}

	int getN() {
		return n;
	}
/*
	public static void main(String[] args) {
		Factorial f1 = new Factorial(0);
		System.out.println(f1.getN() + "!=" + f1.getResult());
		Factorial f2 = new Factorial(-10);
		System.out.println(f2.getN() + "!=" + f2.getResult());
		Factorial f3 = new Factorial(1);
		System.out.println(f3.getN() + "!=" + f3.getResult());
		Factorial f4 = new Factorial(2);
		System.out.println(f4.getN() + "!=" + f4.getResult());
		Factorial f5 = new Factorial(10);
		System.out.println(f5.getN() + "!=" + f5.getResult());
		Factorial f6 = new Factorial(100);
		System.out.println(f6.getN() + "!=" + f6.getResult());
	}
*/	
}
