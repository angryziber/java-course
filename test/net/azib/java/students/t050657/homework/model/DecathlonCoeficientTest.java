package net.azib.java.students.t050657.homework.model;

import junit.framework.TestCase;

import org.junit.Test;
/**
 * DecathlonCoeficient
 *
 * @author Boriss
 */
public class DecathlonCoeficientTest extends TestCase{
	
	@Test
	public void testEvalPoints(){
		DecathlonCoeficient m100 = DecathlonCoeficient.M_100;
		DecathlonCoeficient highJump = DecathlonCoeficient.HIGH_JUMP;

		assertEquals(1096.6265758314423, m100.evalPoints(10.00));
		assertEquals(283.5317758308903, highJump.evalPoints(135));	
	}
	
	@Test
	public void testReduceToFormat() {
		DecathlonCoeficient m100 = DecathlonCoeficient.M_100;
		DecathlonCoeficient highJump = DecathlonCoeficient.HIGH_JUMP;
		
		assertEquals(152.02, m100.reduceToFormat("2:32.02", "min:sec"));
		assertEquals(204.99999999999997, highJump.reduceToFormat("2.05", "m"));
	}
}
