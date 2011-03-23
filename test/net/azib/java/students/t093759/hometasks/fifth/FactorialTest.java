package net.azib.java.students.t093759.hometasks.fifth;

import org.junit.Test;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author dionis
 *         23.03.11 12:48
 */
public class FactorialTest {
	@Test
	public void firstFactorialValue() {
		assertThat(new Factorial(0).getValue(), is(BigInteger.ONE));
	}

	@Test
	public void secondFactorialValue() {
		assertThat(new Factorial(1).getValue(), is(BigInteger.ONE));
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeIndexForFactorialValue() {
		new Factorial(-1);
	}

	@Test
	public void firstFewFactorialValues() {
		Map<Integer, BigInteger> firstFewFactorialValues = createFirstFewFactorialValueMap();

		BigInteger calculatedFactorialValue;
		BigInteger realFactorialValue;

		for (Map.Entry<Integer, BigInteger> factorialIndexWithValue : firstFewFactorialValues.entrySet()) {
			calculatedFactorialValue = new Factorial(factorialIndexWithValue.getKey()).getValue();
			realFactorialValue = factorialIndexWithValue.getValue();

			assertThat(calculatedFactorialValue, is(realFactorialValue));
		}
	}

	@Test
	public void factorialValueShouldRememberIndex() {
		for (int i = 0; i < 10; i++) {
			assertThat(new Factorial(i).getIndex(), is(i));
		}
	}

	@Test
	public void FactorialStringRepresentation() {
		Factorial factorial;
		int index;
		BigInteger value;
		for (int i = 0; i < 10; i++) {
			factorial = new Factorial(i);
			index = factorial.getIndex();
			value = factorial.getValue();

			assertThat(factorial.toString(), is(index + "! = " + value));
		}
	}

	private Map<Integer, BigInteger> createFirstFewFactorialValueMap() {
		Map<Integer, BigInteger> firstFewFactorialValues;
		firstFewFactorialValues = new LinkedHashMap<Integer, BigInteger>();
		firstFewFactorialValues.put(0, BigInteger.ONE);
		firstFewFactorialValues.put(1, BigInteger.ONE);
		firstFewFactorialValues.put(2, BigInteger.valueOf(2));
		firstFewFactorialValues.put(3, BigInteger.valueOf(6));
		firstFewFactorialValues.put(4, BigInteger.valueOf(24));
		firstFewFactorialValues.put(5, BigInteger.valueOf(120));
		firstFewFactorialValues.put(6, BigInteger.valueOf(720));
		return firstFewFactorialValues;
	}
}
