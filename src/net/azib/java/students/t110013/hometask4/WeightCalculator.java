package net.azib.java.students.t110013.hometask4;

import net.azib.java.lessons.enums.Planet;

/**
 * Author: Vadim
 * Date: 14.03.11
 * Time: 20:43
 */
public class WeightCalculator {
	public static void main(String[] args) {
		int myWeight = 70;
		double g = 9.8;
		for (Planet planet : Planet.values()) {
			System.out.printf("On " + planet + " I weight %.2f kg\n", planet.surfaceWeight(myWeight) / g);
		}
	}
}
