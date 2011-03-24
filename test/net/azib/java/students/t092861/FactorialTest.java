package net.azib.java.students.t092861;

import junit.framework.TestCase;
import net.azib.java.students.t092861.lecture2.Factorial;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Stanislav / 092861
 * 
 */
public class FactorialTest extends TestCase{

	@Test
	public void testindexesFromZeroToTwenty() {
		assertFactorialSequence("1, 1, 2, 6, 24, 120, 720, 5040, 40320, "
				+ "362880, 3628800, 39916800, 479001600, 6227020800, "
				+ "87178291200, 1307674368000, 20922789888000, 355687428096000, "
				+ "6402373705728000, 121645100408832000, 2432902008176640000");
	}

	@Test
	public void testtheSumIsAlwaysGreaterThanZero() {
		for (int i = 0; i < 10; i++) {
			assertTrue(new Factorial().generate(i).intValue() > 0);
		}
	}

	private void assertFactorialSequence(String expectedValues) {
		int i = 0;
		for (String string : expectedValues.split(", ")) {
			assertFactorial(i++, new BigInteger(string));
		}
	}

	private void assertFactorial(int i, BigInteger expected) {
		assertThat(new Factorial().generate(i), is(expected));
	}
}
