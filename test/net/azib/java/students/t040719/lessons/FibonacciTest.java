package net.azib.java.students.t040719.lessons;

import static org.junit.Assert.*;
import org.junit.Test;
import java.math.BigInteger;

/**
 * FibonacciTest
 *
 * @author Romi
 */
public class FibonacciTest {
	@Test
	public void testCalculateFib(){
		BigInteger bigInt = new BigInteger("70492524767089125814114");
		Fibonacci f = new Fibonacci();
		assertEquals(bigInt, f.calculateFib(111));
	}
	
	@Test
	public void testGetFiboList(){
		Fibonacci f = new Fibonacci();
		String s = "0 1 1 2 3 5 8 13 21 34 ";
		assertEquals(s, f.getFiboList(10));
	}

}
