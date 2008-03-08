package net.azib.java.students.t001370.lectures.lec4.home;

import static org.junit.Assert.*;

import net.azib.java.lessons.enums.Planet;

import org.junit.Test;

/**
 * WeightCalculatorTest
 *
 * @author maksim
 */
public class WeightCalculatorTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec4.home.WeightCalculator#calcWeight(net.azib.java.lessons.enums.Planet, double)}.
	 */
	@Test
	public void testCalcWeightPlanetDouble() {
		assertEquals("!!!WeightCalculator.calcWeight(PlanetDouble) failed!!!",
				686.185692033599, WeightCalculator.calcWeight(Planet.EARTH, 70));
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.lectures.lec4.home.WeightCalculator#calcWeight(java.lang.String, double)}.
	 */
	@Test
	public void testCalcWeightStringDouble() {
		assertEquals("!!!WeightCalculator.calcWeight(PlanetDouble) failed!!!",
				686.185692033599, WeightCalculator.calcWeight("EARTH", 70));
	}

}
