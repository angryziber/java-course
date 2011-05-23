package net.azib.java.students.t092877.lecture1;

import net.azib.java.students.t092877.lecture2.Factorial;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FactorialTest {

	Factorial factorial = new Factorial();

	@Test
	public void testTheSumIsAlwaysGreaterThanZero() {

		for (int i = 0; i < 10; i++)
			assertTrue(factorial.compute(i).intValue() > 0);
	}

	@Test
	public void testFirstTwentyElements() {

		String factorialSequenceAsStr = "1 2 6 24 120 720 5040 40320 362880 3628800 " +
									"39916800 479001600 6227020800 87178291200 " +
									"1307674368000 20922789888000 355687428096000 " +
									"6402373705728000 121645100408832000 2432902008176640000";

		String[] factorialSequenceElements = factorialSequenceAsStr.split("\\s+");
		BigInteger[] elements = new BigInteger[20];

		for (int i = 0; i < factorialSequenceElements.length; i++) {
			elements[i] = new BigInteger(factorialSequenceElements[i]);
			assertEquals(elements[i], factorial.compute(i+1));
		}
	}
}
