package net.azib.java.students.t073639.homework;

import java.math.BigInteger;

/**
 * Factorial
 * 
 * @author t073639
 */
public class Factorial {
	BigInteger getFactorialNumber(int number) {
		if (number == 1 || number == 0)
			return BigInteger.ONE;
		else {
			BigInteger[] factArray = new BigInteger[number + 1];
			factArray[0] = BigInteger.ONE;
			factArray[1] = BigInteger.ONE;
			int i = 0;
			while (i < factArray.length - 2) {
				factArray[i + 2] = factArray[i + 1].multiply(BigInteger.valueOf(i + 2));
				i++;
			}
			return factArray[factArray.length - 1];
		}
	}
}
