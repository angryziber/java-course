package net.azib.java.students.t040771.Hometasks;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author raido
 */
public class Fibonacci {
	private static BigInteger fFibonacci(int n) {
		if(n == 0) return BigInteger.ZERO;
		if(n == 1) return BigInteger.ONE;
		BigInteger smaller = BigInteger.ZERO;
		BigInteger bigger = BigInteger.ONE;
		BigInteger temporary = BigInteger.ZERO;
		
		for(int i=1;i<n;i++) {
			temporary = bigger;
			bigger = bigger.add(smaller);
			smaller = temporary;
		}
		
		return bigger;
	}
	
	public static void main(String[] args) {
		System.out.println(fFibonacci(100));
	}
}
