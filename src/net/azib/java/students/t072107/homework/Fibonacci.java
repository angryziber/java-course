package net.azib.java.students.t072107.homework;

import java.math.BigInteger;

/**
 * Homework nr.1.1: Fibonacci
 *
 * @author Andrei Kortsak
 */

public class Fibonacci {

	public static void main(String[] args) {

		int thFiboNumber = 100;
		BigInteger currentFiboNumber = BigInteger.ONE;
		BigInteger previousFiboNumber = BigInteger.ZERO;
		BigInteger temporaryFiboNumber = BigInteger.ZERO;

		// Fibonacci Numbers Algorithm
		for (int i = 1; i < thFiboNumber; i++) {			
			temporaryFiboNumber = currentFiboNumber;
			currentFiboNumber = currentFiboNumber.add(previousFiboNumber);
			previousFiboNumber = temporaryFiboNumber;
		}

		System.out.println(thFiboNumber + "th generated Fibonacci number:");
		System.out.println(currentFiboNumber);
	}
}