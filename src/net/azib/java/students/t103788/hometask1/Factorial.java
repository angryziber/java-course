package net.azib.java.students.t103788.hometask1;

import java.math.BigInteger;

public class Factorial {
	private BigInteger[] sequence;

	public Factorial(int length) {
		sequence = new BigInteger[length];

		sequence[0] = new BigInteger("1");

		for (int n = 1; n < length; n++) {
			sequence[n] = sequence[n - 1].multiply(new BigInteger(Integer.toString(n)));
		}

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (BigInteger element : sequence) {
			sb.append(element.toString() + "\n");
		}

		return sb.toString();
	}

	public String toString(int elementNumber) {

		return sequence[elementNumber - 1].toString();
	}
}
