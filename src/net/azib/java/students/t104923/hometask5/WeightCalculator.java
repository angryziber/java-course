package net.azib.java.students.t104923.hometask5;

import net.azib.java.lessons.enums.Planet;

public class WeightCalculator {
	public static void main(String[] args) {
		double myCatsMass = 10;
		for (Planet planet : Planet.values()) {
			System.out.println("My cat weights " + Math.round(planet.surfaceWeight(myCatsMass) / Planet.EARTH.surfaceGravity()) + " kg" + " on planet " + planet);
		}
	}
}
