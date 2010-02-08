package net.azib.java.students.t092874;

import java.math.BigInteger;

/**
 * Factorial 
 * 08.02.2010 
 * Lecture 2: Java Basics, Program flow
 * 
 * @author Aleksandr Gladki
 */
class Factorial {
	BigInteger calculate(int count) {
		BigInteger result = BigInteger.ONE;
		do {
			result = result.multiply(new BigInteger(Integer.toString(count, 10)));
		}
		while (--count > 0);
		return result;
	}
}
