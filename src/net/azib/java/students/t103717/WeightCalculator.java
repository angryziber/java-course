package net.azib.java.students.t103717;

import net.azib.java.lessons.enums.Planet;

import static java.lang.System.out;

/**
 * User: ruzard
 * Malyshev Konstantin 103717IAPB28
 * Date: 17.03.11
 */
public class WeightCalculator {
	public static void main(String[] args) {
		double mass = 65;

		for (Planet planet : Planet.values()) {
			out.format("My planet is %s. I weight there %4.2f kg \n", planet, WeightCalculator.calculate(planet, mass));

		}
	}

	protected static double calculate(Planet planet, double mass) {
		return planet.surfaceWeight(mass) / Planet.EARTH.surfaceGravity();
	}

}
