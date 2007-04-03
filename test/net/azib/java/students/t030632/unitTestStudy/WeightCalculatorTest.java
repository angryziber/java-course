package net.azib.java.students.t030632.unitTestStudy;

import net.azib.java.lessons.enums.Planet;
import net.azib.java.students.t030632.enumTask.WeightCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * WeightCalculatorTest
 *
 * @author Toni
 */
public class WeightCalculatorTest {
	
	
	@Test
	public void testWeight(){
		WeightCalculator wCalc = new WeightCalculator();
		assertEquals( (double)370.3026722965939,wCalc.calculateWeightInSolarSystem((Planet.MERCURY).toString(), (double)100));
	}
	

}
