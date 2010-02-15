package net.azib.java.students.t073639.tasks;

import java.math.BigInteger;

/**
 * Fibonacci
 * 
 * @author t073639
 */
public class Fibonacci {
	BigInteger getFibonacciNumber(int number) {
		if (number > 2) {
			BigInteger[] fiboArray = new BigInteger[number + 1];
			fiboArray[0] = BigInteger.ZERO;
			fiboArray[1] = BigInteger.ONE;
			int i = 0;
			while (i < fiboArray.length - 2) {
				fiboArray[i + 2] = fiboArray[i].add(fiboArray[i + 1]);
				i++;
			}
			return fiboArray[fiboArray.length - 2];
		}
		else if (number == 2)
			return BigInteger.ONE;
		else
			return BigInteger.ZERO;
	}
}
