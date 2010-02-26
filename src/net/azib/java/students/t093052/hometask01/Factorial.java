package net.azib.java.students.t093052.hometask01;

import java.math.BigInteger;

/**
 * Factorial
 *
 * @author Kostja
 */
public class Factorial {

	public static BigInteger[] calculateNumbers(int index) {
		BigInteger[] numbers = new BigInteger[index];
		
		BigInteger temp = BigInteger.ONE;
		for (int i = 0; i < index; i++) {
			temp = temp.multiply(BigInteger.ONE.add(
					new BigInteger(String.valueOf(i))));
			numbers[i] = temp;
		}
		return numbers;
	}
}
