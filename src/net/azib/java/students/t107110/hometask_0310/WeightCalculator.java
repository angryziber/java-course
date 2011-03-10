package net.azib.java.students.t107110.hometask_0310;

import net.azib.java.lessons.enums.Planet;

import java.text.DecimalFormat;
import java.text.Format;

public class WeightCalculator {
	private static final double G = 9.8;
	public static final Format FORMAT = new DecimalFormat("#,##0.0");

	public static void main(final String[] args) {
		final double weight = 93.8;
		final double mass = weight / G;
		for (Planet planet : Planet.values()) {
			System.out.println("weight on " + planet + " is " + FORMAT.format(planet.surfaceWeight(mass)) + " kg");
		}
	}
}
