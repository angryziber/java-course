package net.azib.java.students.t093052.lecture2;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author Kostja
 */
public class Fibonacci {

	public static BigInteger[] calculateNumbers(int index) {
		BigInteger[] numbers = new BigInteger[index];
		
		for (int i = 0; i < index; i++) {
			if (i < 2) {
				numbers[i] = BigInteger.ONE;
			} else {
				numbers[i] = numbers[i - 1].add(numbers[i - 2]);
			}
		}
		return numbers;
	}
}
