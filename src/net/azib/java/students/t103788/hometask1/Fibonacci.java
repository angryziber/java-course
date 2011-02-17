package net.azib.java.students.t103788.hometask1;

import java.math.BigInteger;

public class Fibonacci {
	private BigInteger[] sequence;

	public Fibonacci(int length) {

		if (length < 2)
			length = 2;

		sequence = new BigInteger[length];
		sequence[0] = new BigInteger("0");
		sequence[1] = new BigInteger("1");

		for (int i = 2; i < length; i++) {
			sequence[i] = sequence[i - 2].add(sequence[i - 1]);
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