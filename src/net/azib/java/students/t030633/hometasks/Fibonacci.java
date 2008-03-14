package net.azib.java.students.t030633.hometasks;

import java.math.BigInteger;

/**
 * Prints the 100-th Fibonacci number using an Iterative algorithm.
 * 
 * @author t030633
 */
public class Fibonacci {

	public BigInteger fibonacciNumber(int number) {

		if (number == 0)
			return BigInteger.ZERO;

		BigInteger low = BigInteger.ZERO;
		BigInteger high = BigInteger.ONE;

		for (int i = 1; i < number; i++) {
			high = high.add(low);
			low = high.subtract(low);
		}

		return high;

	}

}
