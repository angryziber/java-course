package net.azib.java.students.t030633.hometasks;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

/**
 * FactorialTest
 * 
 * @author t030633
 */
public class FactorialTest {

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.Factorial#recProduct(int, int)}.
	 */
	@Test
	public void computeFactorialOf100() {
		Factorial f = new Factorial();
		BigInteger b = new BigInteger(
				"93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000");
		assertEquals(b, f.recProduct(1, 100));
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.Factorial#recProduct(int, int)}.
	 */
	@Test
	public void computeFactorialOf10() {
		Factorial f = new Factorial();
		BigInteger b = new BigInteger("3628800");
		assertEquals(b, f.recProduct(1, 10));
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.Factorial#recProduct(int, int)}.
	 */
	@Test
	public void computeFactorialOf5() {
		Factorial f = new Factorial();
		BigInteger b = new BigInteger("120");
		assertEquals(b, f.recProduct(1, 5));
	}

}
