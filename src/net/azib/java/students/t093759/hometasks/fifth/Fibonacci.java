package net.azib.java.students.t093759.hometasks.fifth;

import java.math.BigInteger;

/**
 * 23.03.11 10:26
 *
 * @author Dionis
 */
public class Fibonacci {
	private BigInteger number;
	private Integer index;

	public Fibonacci(int index) {
		calculateFibonacciNumber(index);
		this.index = index;
	}

	private void calculateFibonacciNumber(int index) {
		if (index == 0) number = BigInteger.ZERO;
		else if (index == 1) number = BigInteger.ONE;
		else {
			BigInteger previousNumber = BigInteger.ZERO;
			BigInteger currentNumber = BigInteger.ONE;//set previous value
			for (int i = 2; i <= index; i++) {
				number = currentNumber.add(previousNumber);
				previousNumber = currentNumber;
				currentNumber = number;
			}
		}
	}

	public BigInteger getNumber() {
		return number;
	}

	public Integer getIndex() {
		return index;
	}

	@Override
	public String toString() {
		return "Fibonacci[" + index + "] = " + number;
	}
}
