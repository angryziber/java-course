package net.azib.java.students.t104607;
// @author 104607 IASM

import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.Assert.assertEquals;

public class FactorialTest {
	@Test
	public void computeFirst() throws Exception {
		assertEquals(BigInteger.ONE,new Factorial().compute(0));
	}

	@Test
	public void computeTen() throws Exception {
	  	assertEquals(BigInteger.valueOf(3628800),new Factorial().compute(10));
	}
}
