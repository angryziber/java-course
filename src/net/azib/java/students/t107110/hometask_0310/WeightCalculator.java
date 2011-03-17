package net.azib.java.students.t107110.hometask_0310;

import net.azib.java.lessons.enums.Planet;

import java.text.DecimalFormat;
import java.text.Format;

public class WeightCalculator {
	private static final double EARTH_SURFACE_GRAVITY = Planet.EARTH.surfaceGravity();
	public static final Format FORMAT = new DecimalFormat("#,##0.0");

	public static void main(final String[] args) {
		final double mass = 93.8;
		for (final Planet planet : Planet.values()) {
			final double weightOnPlanet = planet.surfaceWeight(mass) / EARTH_SURFACE_GRAVITY;
			System.out.println("weight on " + planet + " is equivalent of " + FORMAT.format(weightOnPlanet) + " kg");
		}
	}
}
