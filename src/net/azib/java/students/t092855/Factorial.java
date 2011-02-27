package net.azib.java.students.t092855;


import java.math.BigInteger;

public class Factorial {
	/**
	 * Calculates factorial of input parameter.
	 * @param val       Non-negative integer from which to calculate factorial.
	 * @return          Factorial of input parameter.
	 *                  -1 when input parameter is negative.
	 */
	public BigInteger getNumber(int val)	{
		BigInteger result = new BigInteger("-1");

		if (val < 0)
			return result;

		result = new BigInteger("1");

		for(int i = 1; i < val; i++) {
			result = result.multiply(BigInteger.valueOf(i + 1));
		}

		return result;
	}
}
