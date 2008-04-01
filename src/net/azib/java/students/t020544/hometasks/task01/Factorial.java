package net.azib.java.students.t020544.hometasks.task01;

import java.math.BigInteger;

/**
 * Factorial
 * 
 * @author Julija Kondratjeva
 */
public class Factorial {

	int number;

	public BigInteger calculateFactorial(int number) {
		BigInteger result = BigInteger.ONE;
		BigInteger first = BigInteger.ONE;
		BigInteger second = first.add(BigInteger.ONE);

		if (number < 0)
			throw new IllegalArgumentException("index must be positive");

		if (number == 0)
			result = BigInteger.ONE;

		for (int i = 1; i < number; i++) {
			result = first.multiply(second);
			second = second.add(BigInteger.ONE);
			first = result;			
		}

		return result;
	}


}
