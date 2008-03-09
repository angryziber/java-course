package net.azib.java.students.t654321.hometasks;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

/**
 * FactorialTest
 *
 * @author Karl
 */
public class FactorialTest {

	/**
	 * Test method for {@link net.azib.java.students.t654321.hometasks.Factorial#calculateFactorial(52)}.
	 */
	@Test
	public void testCalculateFactorialOfNegativeNumber() {
		Factorial f = new Factorial();
		assertEquals("Calculating factorial of 0 failed!", null, f.calculateFactorial(-1));
	}
	
	/**
	 * Test method for {@link net.azib.java.students.t654321.hometasks.Factorial#calculateFactorial(0)}.
	 */
	@Test
	public void testCalculateFactorialOf0() {
		Factorial f = new Factorial();
		assertEquals("Calculating factorial of 0 failed!", BigInteger.ZERO, f.calculateFactorial(0));
	}
	
	/**
	 * Test method for {@link net.azib.java.students.t654321.hometasks.Factorial#calculateFactorial(1)}.
	 */
	@Test
	public void testCalculateFactorialOf1(){
		Factorial f = new Factorial();
		assertEquals("Calculating factorial of 1 failed!", BigInteger.ONE, f.calculateFactorial(1));
	}
	
	/**
	 * Test method for {@link net.azib.java.students.t654321.hometasks.Factorial#calculateFactorial(18)}.
	 */
	@Test
	public void testCalculateFactorialOf18() {
		Factorial f = new Factorial();
		assertEquals("Calculating factorial of 18 failed!", new BigInteger("6402373705728000"), f.calculateFactorial(18));
	}
}
