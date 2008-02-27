package net.azib.java.students.t072107.homework;

import java.math.BigInteger;

/**
 * Homework nr.1.2: Factorial
 *
 * @author Andrei Kortsak
 */

public class Factorial {

	public static void main(String[] args) {

		int thFactNumber = 100;
		BigInteger currentFactNumber = BigInteger.ONE;

		// Factorial Number Algorithm
		for (int i = 2; i <= thFactNumber; i++) {			
			currentFactNumber = currentFactNumber.multiply(BigInteger.valueOf(i));
		}

		System.out.println(thFactNumber + "th generated Factorial number:");
		System.out.println(currentFactNumber);
	}
}