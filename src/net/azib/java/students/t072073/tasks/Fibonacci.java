package net.azib.java.students.t072073.tasks;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author t072073
 */
public class Fibonacci {
	static int LAST_VALUE = 100;
	private static BigInteger lastFibo = BigInteger.ONE;
	private static BigInteger previousFibo = BigInteger.ZERO;
	private static BigInteger temp = BigInteger.ZERO;
	
	public static void main(String[] args) {
		for (int i = 1; i < LAST_VALUE; i++) {			
			temp = lastFibo;
			lastFibo = lastFibo.add(previousFibo);
			previousFibo = temp;
		}
		System.out.println(LAST_VALUE + "th Fibonacci number is " + lastFibo);
	}
	
}
