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

		for (int i = 1; i < 100; i++) {
			high = high.add(low);
			low = high.subtract(low);
		}

		System.out.println(high);

	}

}
