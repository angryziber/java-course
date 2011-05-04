package net.azib.java.students.t092877.lecture5;

import net.azib.java.lessons.enums.Planet;

public class WeightCalculator {

	public static void main(String[] args) {

		double testMassInKg = 50;

		for (Planet planet : Planet.values())
			System.out.println("Object's weight on " + planet + " is " +
					           Math.round(planet.surfaceWeight(testMassInKg) * 100) / 100.0 + " N");
	}
}
