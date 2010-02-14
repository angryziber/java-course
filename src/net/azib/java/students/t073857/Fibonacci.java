package net.azib.java.students.t073857;

import java.math.BigInteger;

/**
 * Fibonacci sequence class
 *
 * @author Joonas Vali
 */
public class Fibonacci {
	/**
	 * Calculates Fibonacci numbers.
	 * @param index Method returns the number at given index.
	 * @return returns the calculated number as BigInteger.
	 */
	public static BigInteger getFibonacci(int index){		
		
		if(index == 0) return BigInteger.ZERO;
		BigInteger 
			answer = BigInteger.ONE,
			a = BigInteger.ONE, 
			b = BigInteger.ONE;	
		
		// position index or "pos" starts from 2, because first three numbers of the sequence have already been initialized. 
		for(int pos = 2; pos < index; pos++){
			answer = a.add(b);
			a = b;
			b = answer;
		}		
		return answer;		
	}
}
