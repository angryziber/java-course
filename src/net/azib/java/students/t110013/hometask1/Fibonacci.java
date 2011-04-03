package net.azib.java.students.t110013.hometask1;

import java.math.BigInteger;

/**
 * @author Vadim
 */
public class Fibonacci {

    public static BigInteger compute(int index) {
	    if (index < 0)
	        throw new IllegalArgumentException("Negative Fibonacci numbers are not supported!");

	    if (index <= 1)
			return BigInteger.valueOf(index);

	    BigInteger value = BigInteger.ZERO;
	    BigInteger prevValue = BigInteger.ONE;
	    BigInteger prePrevValue = BigInteger.ZERO;

		for (int i = 1; i < index; ++i) {
			value = prePrevValue.add(prevValue);
			prePrevValue = prevValue;
			prevValue = value;
		}

        return value;
    }
}
