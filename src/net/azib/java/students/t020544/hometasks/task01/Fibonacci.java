package net.azib.java.students.t020544.hometasks.task01;

import java.math.BigInteger;

/**
 * Fibonacci
 * 
 * @author Julija Kondratjeva
 */
public class Fibonacci {

	int number;

	public BigInteger calculateFibonacciNumber(int number) {

		if (number < 0)
			throw new IllegalArgumentException("index must be positive");

		BigInteger result = BigInteger.ONE;
		BigInteger firstNumber = BigInteger.ZERO;
		BigInteger secondNumber = BigInteger.ONE;

		if (number == 0) {
			result = BigInteger.ZERO;
		}

		for (int i = 1; i < number; i++) {

			secondNumber = firstNumber;
			firstNumber = result;
			result = firstNumber.add(secondNumber);
		}

		return result;
	}

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println(f.calculateFibonacciNumber(0));
	}

}
