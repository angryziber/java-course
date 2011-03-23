package net.azib.java.students.t093759.hometasks.fifth;

import java.math.BigInteger;

/**
 * @author dionis
 *         23.03.11 12:47
 */
public class Factorial {
	private BigInteger value;
	private int index;

	public Factorial(int index) {
		if (index < 0)
			throw new IllegalArgumentException();
		calculateFactorial(index);
		this.index = index;
	}

	private void calculateFactorial(int index) {
		if (index == 0)
			value = BigInteger.ONE;
		else {
			BigInteger previous = BigInteger.ONE;
			for (Integer i = 1; i <= index; i++) {
				value = previous.multiply(new BigInteger(i.toString()));
				previous = value;
			}
		}
	}

	public BigInteger getValue() {
		return value;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		return index + "! = " + value;
	}
}
