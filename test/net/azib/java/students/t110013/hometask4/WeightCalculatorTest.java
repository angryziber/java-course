package net.azib.java.students.t110013.hometask4;

import net.azib.java.lessons.enums.Planet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Vadim
 */
public class WeightCalculatorTest {

	@Test
	public void weightOnEarth() {
		assertEquals(70.0, WeightCalculator.calculateWeightOnPlanet(70, Planet.EARTH), 0.1);
	}

	@Test
	public void weightOnNeptune() {
		assertEquals(79.7, WeightCalculator.calculateWeightOnPlanet(70, Planet.NEPTUNE), 0.1);
	}
}
