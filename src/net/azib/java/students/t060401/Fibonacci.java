package net.azib.java.students.t060401;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author t060401
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BigInteger [] numbers = new BigInteger[100]; 
		numbers [0] = BigInteger.ZERO;
		numbers [1] = BigInteger.ONE;
		
		BigInteger fibonacciNumber = BigInteger.ZERO;
		
		for (int i=1; i<99; i++ ) {
			fibonacciNumber = ((BigInteger)numbers[i-1]).add((BigInteger)numbers[i]);
			numbers[i+1] = fibonacciNumber;
		}
		System.out.println("100-s Fibonacci number: "+fibonacciNumber);
		
		for (BigInteger number : numbers) {
			System.out.println(number);
		}
		
	}

}
