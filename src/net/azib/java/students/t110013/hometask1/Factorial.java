package net.azib.java.students.t110013.hometask1;

import java.math.BigInteger;

/**
 * @author Vadim
 */
public class Factorial {

	public static BigInteger compute(int index) {
	    if (index < 0)
			throw new IllegalArgumentException("Factorials of negative integers are not supported!");

	    BigInteger value = BigInteger.ONE;

		for (int i = 1; i <= index; i++) {
			value = value.multiply(BigInteger.valueOf(i));
		}

        return value;
    }
}
