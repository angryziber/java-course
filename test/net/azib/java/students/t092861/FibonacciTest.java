package net.azib.java.students.t092861;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.math.BigInteger;

import junit.framework.TestCase;
import net.azib.java.students.t092861.lecture2.Fibonacci;
import org.junit.Test;

/**
 * @author Stanislav / 092861
 * 
 */
public class FibonacciTest  extends TestCase{

	@Test
	public void testindexesFromTwoToThirtyEight() {
		String string = "0,1,1,2,3,5,8,13,21,34,55,89,"
				+ "144,233,377,610,987,1597,2584,4181,6765,"
				+ "10946,17711,28657,46368,75025,121393,"
				+ "196418,317811,514229,832040,1346269,2178309,"
				+ "3524578,5702887,9227465,14930352,24157817,39088169";
		String[] numbers = string.split(",");
		for (int index = 2, number = 2; index <= 39 && number < numbers.length; index++, number++) {
			assertEquals(new BigInteger(numbers[number]), new Fibonacci().generate(index));
		}
	}

	@Test
	public void testindexIsZero() {
		assertFibonacci(0, new BigInteger("0"));
	}

	@Test
	public void testindexIsOne() {
		assertFibonacci(1, new BigInteger("1"));
	}

	@Test
	public void testindexIsTwo() {
		assertFibonacci(2, new BigInteger("1"));
	}

	private void assertFibonacci(int index, BigInteger expected) {
		Fibonacci fibonacci = new Fibonacci();
		assertThat(fibonacci.generate(index), is(expected));
	}
}
