package net.azib.java.students.t030655.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * DecathlonTest
 *
 * @author Triin Nestor
 */
public class DecathlonTest {
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030655.homework.Decathlon#points(double)}
	 * 
	 */
	@Test
	public void testPoints() {
		double result1 = 30.85;
		double discusThrow = 12.91*Math.pow((result1-4.0), 1.1);
		assertEquals(discusThrow, Decathlon.DISCUS_THROW.points(result1));
		
		double result2 = 18.74;
		double hurdles110m = 5.74352*Math.pow((28.5-result2), 1.92);
		assertEquals(hurdles110m, Decathlon.HURDLES_110M.points(result2));
	}
	
	

}
