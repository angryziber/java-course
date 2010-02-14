package net.azib.java.students.t073857;

import java.math.BigInteger;

/**
 * Factorial class
 *
 * @author Joonas Vali
 */
public class Factorial {
	/**
	 * Calculate factorial
	 * @param value integer, based on which the factorial will be calculated.
	 * @return returns the calculated value as BigInteger.
	 */
	public static BigInteger getFactorial(int value){		
		BigInteger b = new BigInteger(Integer.toString(value));
		if(value < 0) return b;
		BigInteger answer = BigInteger.ONE;
		for(; value > 0; value--){
			b = new BigInteger(Integer.toString(value));			
			answer = answer.multiply(b);			
		}
		return answer;
	}
}
