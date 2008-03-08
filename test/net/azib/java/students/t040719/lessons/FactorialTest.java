package net.azib.java.students.t040719.lessons;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

/**
 * FactorialTest
 *
 * @author Romi
 */
public class FactorialTest {

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Factorial#getFactList(int)}.
	 */
	@Test
	public void testGetFactList() {
		Factorial f = new Factorial();
		String s = "1 1 2 6 24 120 720 5040 40320 362880 ";
		assertEquals(s, f.getFactList(10));
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Factorial#calculateFact(int)}.
	 */
	@Test
	public void testCalculateFact() {
		Factorial f = new Factorial();
		BigInteger bigInt = new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000");
		assertEquals(bigInt, f.calculateFact(100));
	}

}
