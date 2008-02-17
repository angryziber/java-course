package net.azib.java.students.t040771.Hometasks;

import java.math.BigInteger;

/**
 * Factorial
 *
 * @author raido
 */
public class Factorial {
	public static BigInteger fFactorial(int n) {
		BigInteger x = BigInteger.ONE;
		for(int i=1;i<=n;i++) {
			x = x.multiply(BigInteger.valueOf(i));
		}
		return x;
	}
	
	public static void main(String[] args) {
		System.out.println(fFactorial(100));
	}
}
