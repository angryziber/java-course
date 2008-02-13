package net.azib.java.students.t980814;

import java.math.BigInteger;

/**
 * Factorial
 *
 * @author allan
 */
public class Factorial {

	BigInteger fact;
	int n;
	
	Factorial(int n) {
		BigInteger multiplier = new BigInteger("1");

		if (n < 0)
			n = 0;
	
		fact = BigInteger.ONE;
		this.n = n;
		for(int i = 0; i < n; i++)
		{
			fact = fact.multiply(multiplier);
			multiplier = multiplier.add(BigInteger.ONE);
		}
	}

	BigInteger getResult() {
		return fact;
	}
	
	int getN() {
		return n;
	}
	
	public static void main(String[] args) {
		Factorial f = new Factorial(100);
		System.out.println(f.getN() + "!=" + f.getResult());
	}
}
