package net.azib.java.students.t073639.taskGui;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CalculatorTest
 * 
 * @author t073639
 */
public class CalculatorTest {
	private static final double delta = 0.001;
	Calculator c = new Calculator();
	double d1 = 22544.45;
	double d2 = 4587.73;

	@Test
	public void multiply() throws Exception {
		double d = c.multiply(d1, d2);
		assertEquals(d1*d2, d, delta);
	}

	@Test
	public void divide() throws Exception {
		double d=c.divide(d1,d2);
		assertEquals(d1/d2, d, delta);
	}
	@Test
	public void add() throws Exception {
		double d = c.add(d1,d2);
		assertEquals(d1+d2, d, delta);
	}
	@Test
	public void subtract() throws Exception {
		double d=c.subtract(d1,d2);
		assertEquals(d1-d2, d, delta);
	}
}
