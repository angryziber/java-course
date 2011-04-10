package net.azib.java.students.t092855.lecture5;

import net.azib.java.lessons.enums.Planet;

public class WeightCalculator {

	public static void main(String[] args) {
		double myWeight = 74.600;

		double myMass = myWeight/Planet.EARTH.surfaceGravity();
		for(Planet planet : Planet.values()) {
			System.out.printf("I weigh  %.3f on planet %s\n", planet.surfaceWeight(myMass), planet.name());
		}
	}
}
