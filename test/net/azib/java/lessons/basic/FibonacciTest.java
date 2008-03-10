package net.azib.java.lessons.basic;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;


/**
 * FibonacciTest
 *
 * @author anton
 */
public class FibonacciTest {
	private Fibonacci fibonacci = new Fibonacci();
	
	@Test(expected=IllegalArgumentException.class)
	public void illegalArgumentFails() throws Exception {
		fibonacci.compute(-1);
	}
	
	@Test
	public void zeroIsZero() {
		assertCorrect("0", 0);
	}

	@Test
	public void firstTwoNumbersAreOnes() {
		assertCorrect("1", 1);
		assertCorrect("1", 2);
	}
	
	@Test
	public void compute3rdNumber() {
		assertCorrect("2", 3);
	}
	
	@Test
	public void compute7thNumber() {
		assertCorrect("13", 7);
	}

	@Test
	public void compute100thNumber() {
		assertCorrect("354224848179261915075", 100);
	}

	/** Helper method for asserting {@link Fibonacci#compute(int)} calls */
	private void assertCorrect(String expected, int index) {
		assertEquals(new BigInteger(expected), fibonacci.compute(index));
	}
}
