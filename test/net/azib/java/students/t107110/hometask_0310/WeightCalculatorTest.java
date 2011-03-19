package net.azib.java.students.t107110.hometask_0310;

import org.junit.Test;

import static net.azib.java.lessons.enums.Planet.EARTH;
import static net.azib.java.lessons.enums.Planet.MARS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public class WeightCalculatorTest {
	@Test
	public void weightOnEarth() {
		assertThat(WeightCalculator.weightOnPlanet(78.9, EARTH), is(78.9));
	}

	@Test
	public void weightOnMars() {
		assertThat(WeightCalculator.weightOnPlanet(78.9, MARS), is(29.9));
	}
}
