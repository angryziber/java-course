package net.azib.java.students.t092874;

import java.math.BigInteger;

/**
 * Fibonacci 
 * 08.02.2010 
 * Lecture 2: Java Basics, Program flow
 * 
 * @author Aleksandr Gladki
 */
class Fibonacci {
	BigInteger calulate(int count) {
		BigInteger firstNum = BigInteger.ZERO, secondNum = BigInteger.ONE;
		while (--count >= 0) {
			BigInteger tempNum = firstNum;
			firstNum = secondNum;
			secondNum = tempNum.add(secondNum);
		}
		return firstNum;
	}
}
