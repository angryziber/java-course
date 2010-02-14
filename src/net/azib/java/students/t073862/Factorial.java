package net.azib.java.students.t073862;

import java.math.BigInteger;

/**
 * Factorial
 *
 * @author Pets
 */
public class Factorial {
	/**
	 * Calculates Factorial to the n-th
	 * @param n
	 * @return
	 */
	public BigInteger calculateFactorial(int n) { 
		BigInteger result = BigInteger.ONE;
		
		for(int i = 1; i < n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		
		return result;
	}
}
