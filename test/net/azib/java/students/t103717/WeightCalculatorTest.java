package net.azib.java.students.t103717;

import net.azib.java.lessons.enums.Planet;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * User: ruzard
 * Malyshev Konstantin 103717IAPB28
 * Date: 24.03.11
 */
public class WeightCalculatorTest {
	@Ignore
	@Test
	public void checkWeightOnEarth() {
		//Todo fix-it
		assertWeightCalc(Planet.EARTH, 10, 11); //should be fail, unfortunately runs perfectly.
	}

	//I could do more hovewer I don't remember how to turn on testing (which program parameter should be used) and it is almost 3:30 am
	private void assertWeightCalc(Planet planet, double mass, double expected) {
		assertThat(WeightCalculator.calculate(planet, mass), equalTo(expected));
	}

}
