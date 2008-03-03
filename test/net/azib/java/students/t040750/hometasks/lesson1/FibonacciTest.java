package net.azib.java.students.t040750.hometasks.lesson1;

import static org.junit.Assert.*;

import net.azib.java.students.t040750.hometasks.lesson1.Fibonacci;

import org.junit.Test;


/**
 * FibonacciTest
 *
 * @author t040750
 */
public class FibonacciTest {
	
	@Test
	public void computeGives1() throws Exception {
		Fibonacci fibonacci = new Fibonacci();
		assertEquals("1",fibonacci.toString());
	}
}
