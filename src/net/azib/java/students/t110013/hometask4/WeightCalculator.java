package net.azib.java.students.t110013.hometask4;

import net.azib.java.lessons.enums.Planet;

/**
 * @author Vadim
 */
public class WeightCalculator {

	public static void main(String[] args) {
		for (Planet planet : Planet.values()) {
			System.out.printf("On " + planet + " my weight is %.2f kg\n", calculateWeightOnPlanet(70, planet));
		}
	}

	public static double calculateWeightOnPlanet(double mass, Planet planet) {
		return planet.surfaceWeight(mass) / Planet.EARTH.surfaceGravity();
	}
}
