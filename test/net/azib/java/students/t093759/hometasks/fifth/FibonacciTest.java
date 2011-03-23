package net.azib.java.students.t093759.hometasks.fifth;

import org.junit.Test;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 23.03.11 10:20
 *
 * @author Dionis
 */
public class FibonacciTest {
	@Test
	public void firstFibonacciNumber() {
		assertThat(new Fibonacci(0).getNumber(), is(BigInteger.ZERO));
	}

	@Test
	public void secondFibonacciNumber() {
		assertThat(new Fibonacci(1).getNumber(), is(BigInteger.ONE));
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeIndexForFibonacciNumber() {
		new Fibonacci(-1);
	}

	@Test
	public void firstFewFibonacciNumbers() {
		Map<Integer, BigInteger> firstFewFibonacciNumbers = createFirstFewFibonacciNumberMap();

		BigInteger calculatedFibonacciNumber;
		BigInteger realFibonacciNumber;

		for (Map.Entry<Integer, BigInteger> fibonacciIndexWithValue : firstFewFibonacciNumbers.entrySet()) {
			calculatedFibonacciNumber = new Fibonacci(fibonacciIndexWithValue.getKey()).getNumber();
			realFibonacciNumber = fibonacciIndexWithValue.getValue();

			assertThat(calculatedFibonacciNumber, is(realFibonacciNumber));
		}
	}

	@Test
	public void fibonacciNumberShouldRememberIndex() {
		for (int i = 0; i < 10; i++) {
			assertThat(new Fibonacci(i).getIndex(), is(i));
		}
	}

	@Test
	public void fibonacciStringRepresentation() {
		Fibonacci fibonacciNumber;
		int index;
		BigInteger number;
		for (int i = 0; i < 10; i++) {
			fibonacciNumber = new Fibonacci(i);
			index = fibonacciNumber.getIndex();
			number = fibonacciNumber.getNumber();

			assertThat(fibonacciNumber.toString(), is("Fibonacci[" + index + "] = " + number));
		}
	}

	private Map<Integer, BigInteger> createFirstFewFibonacciNumberMap() {
		Map<Integer, BigInteger> firstFewFibonacciNumbers;
		firstFewFibonacciNumbers = new LinkedHashMap<Integer, BigInteger>();
		firstFewFibonacciNumbers.put(0, BigInteger.ZERO);
		firstFewFibonacciNumbers.put(1, BigInteger.ONE);
		firstFewFibonacciNumbers.put(2, BigInteger.valueOf(1));
		firstFewFibonacciNumbers.put(3, BigInteger.valueOf(2));
		firstFewFibonacciNumbers.put(4, BigInteger.valueOf(3));
		firstFewFibonacciNumbers.put(5, BigInteger.valueOf(5));
		firstFewFibonacciNumbers.put(6, BigInteger.valueOf(8));
		return firstFewFibonacciNumbers;
	}
}
