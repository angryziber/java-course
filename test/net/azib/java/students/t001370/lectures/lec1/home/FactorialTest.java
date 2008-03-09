package net.azib.java.students.t001370.lectures.lec1.home;

import static org.junit.Assert.*;

import net.azib.java.students.t001370.lectures.lec1.Factorial;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * FactorialTest
 *
 * @author maksim
 */
public class FactorialTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec1.Factorial#calcFactorial(int)}.
	 */
	@Test
	public void testCalcFactorial() {
		assertEquals("!!!Factorial has an error!!!",
				new BigDecimal(120), (Object)Factorial.calcFactorial(5));
	}

}
