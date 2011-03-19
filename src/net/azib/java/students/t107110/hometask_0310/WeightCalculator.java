package net.azib.java.students.t107110.hometask_0310;

import net.azib.java.lessons.enums.Planet;

/**
 * @author Eduard Shustrov
 */
public class WeightCalculator {
	private static final double EARTH_SURFACE_GRAVITY = Planet.EARTH.surfaceGravity();

	public static void main(final String[] args) {
		final double mass = 93.8;
		for (final Planet planet : Planet.values())
			System.out.println("weight on " + planet + " is equivalent of " + weightOnPlanet(mass, planet) + " kg");
	}

	public static double weightOnPlanet(final double mass, final Planet planet) {
		return Math.round((planet.surfaceWeight(mass) / EARTH_SURFACE_GRAVITY) * 10) / 10.0;
	}
}
