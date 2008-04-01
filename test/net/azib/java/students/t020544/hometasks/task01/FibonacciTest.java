package net.azib.java.students.t020544.hometasks.task01;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Test;

/**
 * FibonacciTest
 *
 * @author Julija Kondratjeva
 */
public class FibonacciTest {
	
	Fibonacci f = new Fibonacci();
	
	@Test(expected=IllegalArgumentException.class)
	public void expectedExeption() throws Exception {
		f.calculateFibonacciNumber(-1);
	}
	
	@Test public void calculateNumber0() throws Exception {
		assertEquals(0, f.calculateFibonacciNumber(0));
	}
	
	@Test
	public void calculateNumber10() throws Exception {
		assertEquals(55, f.calculateFibonacciNumber(10));
	}
	
	@Test
	public void calculateNumber100() throws Exception {
		assertEquals("354224848179261915075", f.calculateFibonacciNumber(100).toString());
	}
	
	
}
