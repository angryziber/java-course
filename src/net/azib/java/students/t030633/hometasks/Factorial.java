package net.azib.java.students.t030633.hometasks;

import java.math.BigInteger;

/**
 * Prints 100! using the Recursive Product algorithm.
 * 
 * @author t030633
 */
public class Factorial {

	public static void main(String[] args) {
		
		System.out.print(recProduct(1, 100));
		
	}

	/**
	 * Calculates recursive product of a factorial subsequence.
	 * @param n
	 * @param len
	 * @return
	 */
	private static BigInteger recProduct(int n, int len) {
		
		if (1 < len) {
			int l = len / 2;
			return recProduct(n, l).multiply(recProduct(n + l, len - l));
		}
		
		return BigInteger.valueOf(n);
		
	}

}
