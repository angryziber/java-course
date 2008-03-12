package net.azib.java.students.t980814;

import net.azib.java.students.t980814.lec1.Factorial;
import java.math.BigInteger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * FactorialTest
 *
 * @author dell
 */
public class FactorialTest {

	@Test
	public void testFactorialResultZero() {
		Factorial fact = new Factorial(0);
		assertEquals("Factorial 0 failed", BigInteger.ONE, fact.getResult());
		fact = new Factorial(-10);
		assertEquals("Factorial (negative) failed", BigInteger.ONE, fact.getResult());
		fact = new Factorial(1);
		assertEquals("Factorial 0 failed", BigInteger.ONE, fact.getResult());
	}	
	
	@Test
	public void testFactorialResultTwo() {
		Factorial fact = new Factorial(2);
		assertEquals("Factorial 0 failed", new BigInteger("2"), fact.getResult());
	}

	@Test
	public void testFactorialResult120() {
		Factorial fact = new Factorial(5);
		assertEquals("Factorial 0 failed", new BigInteger("120"), fact.getResult());
	}

	@Test
	public void testFactorial10th() {
		Factorial fact = new Factorial(10);
		assertEquals("Factorial 0 failed", new BigInteger("3628800"), fact.getResult());
	}
}
