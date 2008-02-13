package net.azib.java.students.t030633;

import java.math.BigInteger;

/**
 * Fibonacci. Prints the 100-th Fibonacci number using an Iterative algorithm.
 * 
 * @author t030633
 */
public class Fibonacci {

	public static void main(String[] args) {

		BigInteger low = BigInteger.ZERO;
		BigInteger high = BigInteger.ONE;

		for (BigInteger i = BigInteger.ONE; i.compareTo(BigInteger.valueOf(100)) < 0; i = i.add(BigInteger.ONE)) {
			high = high.add(low);
			low = high.subtract(low);
		}
		
		System.out.print(high);
		
	}

}
