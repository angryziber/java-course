package net.azib.java.students.t072073.tasks;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;


/**
 * FactorialTest
 *
 * @author janika
 */
public class FactorialTest {
  @Test
	public void testReturnsOne() throws Exception {
	  BigInteger result1 = Factorial.calculate(BigInteger.ZERO);
	  assertEquals(BigInteger.ONE, result1);
	  BigInteger result2 = Factorial.calculate(BigInteger.ONE);
	  assertEquals(BigInteger.ONE, result2);
	  BigInteger result3 = Factorial.calculate(BigInteger.valueOf(-7));
	  assertEquals(BigInteger.ONE, result3);
	}
  
  @Test
  public void testFactorialOfTwelve() throws Exception {
	  BigInteger result = Factorial.calculate(BigInteger.valueOf(12));
	  assertEquals("479001600", result.toString());
  }
}
