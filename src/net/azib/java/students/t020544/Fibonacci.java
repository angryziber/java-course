package net.azib.java.students.t020544;

import java.math.BigInteger;

/**
 * Fibonacci
 * 
 * @author Julija Kondratjeva
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BigInteger rezult = BigInteger.ZERO;
		BigInteger firstNumber = BigInteger.ONE;
		BigInteger secondNumber = BigInteger.ZERO;

		for (int i = 0; i < 100; i++) {
			rezult = firstNumber.add(secondNumber);
			firstNumber = secondNumber;
			secondNumber = rezult;

		}

		System.out.println(rezult);
	}

}
