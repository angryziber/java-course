package net.azib.java.students.t980814;

import net.azib.java.students.t980814.lec4.WeigthCalculator;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * WeigthCalculatorTest
 *
 * @author allan
 */
public class WeigthCalculatorTest {

	@Test
	public void testWeigthCalculatorZero() {
		WeigthCalculator wCalc = new WeigthCalculator(0);
		assertEquals(new StringBuilder("The person weights: \n").
				         append("0kg on MERCURY\n").
				         append("0kg on VENUS\n").
				         append("0kg on EARTH\n").
				         append("0kg on MARS\n").
				         append("0kg on JUPITER\n").
				         append("0kg on SATURN\n").
				         append("0kg on URANUS\n").
				         append("0kg on NEPTUNE\n").
				         append("0kg on PLUTO\n").toString(), 
    				wCalc.toString());
	}
	
	@Test
	public void testWeigthCalculator100kg() {
		WeigthCalculator wCalc = new WeigthCalculator(100);
		assertEquals(new StringBuilder("The person weights: \n").
				         append("37kg on MERCURY\n").
				         append("90kg on VENUS\n").
				         append("100kg on EARTH\n").
				         append("37kg on MARS\n").
				         append("253kg on JUPITER\n").
				         append("106kg on SATURN\n").
				         append("90kg on URANUS\n").
				         append("113kg on NEPTUNE\n").
				         append("6kg on PLUTO\n").toString(), 
    				wCalc.toString());
	}
}
