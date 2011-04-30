package net.azib.java.students.t092855;

import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FactorialTest {
	@Test
	public void firstNumberIsCorrect() {
		assertEquals(new BigInteger("1"), new Factorial().getNumber(0));
	}

	@Test
	public void secondNumberIsCorrect() {
		assertEquals(BigInteger.ONE, new Factorial().getNumber(1));
	}

	@Test
	public void thirdNumberIsCorrect() {
		assertEquals(BigInteger.valueOf(2), new Factorial().getNumber(2));
	}

	@Test
	public void negativeNumberIsHandledCorrectly() {
		assertEquals(new BigInteger("-1"), new Factorial().getNumber(-40));
	}

	@Test
	public void someBigNumberIsCorrect() {
		assertEquals(new BigInteger("2432902008176640000"), new Factorial().getNumber(20));
	}

	@Test @Ignore
	public void thisIsIgnored() {
	}

}
