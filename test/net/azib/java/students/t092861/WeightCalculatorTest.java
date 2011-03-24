package net.azib.java.students.t092861;

import net.azib.java.lessons.enums.Planet;
import net.azib.java.students.t092861.lecture5.WeightCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Stanislav / 092861
 * 
 */
public class WeightCalculatorTest {

	public enum CorrectResults {
		MERCURY(26.4), 
		VENUS(63.4), 
		MARS(26.3), 
		SATURN(74.4), 
		URANUS(62.2), 
		NEPTUNE(78.7), 
		JUPITER(172.4), 
		MOON(11.6), 
		PLUTO(4.6);

		private final double id;

		CorrectResults(double id) {
			this.id = id;
		}

		public double getValue() {
			return id;
		}
	}

	public static final int MY_MASS = 70;
	WeightCalculator weightCalc = new WeightCalculator();
	
	@Test
	public void calculateWeightOnOtherPlanetes() {
		CorrectResults[] resultsArray = CorrectResults.values();
		for (Planet curPlanet : Planet.values()) {
			for (int i = 0; i < resultsArray.length; i++) {
				if (curPlanet.name() == resultsArray[i].toString()) {
					assertEquals(resultsArray[i].getValue(),
							weightCalc.calculateWeight(curPlanet, MY_MASS),	5.50);
				}
			}
		}

	}
}
