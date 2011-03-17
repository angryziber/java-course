package net.azib.java.students.t104607;
// @author 104607 IASM

import net.azib.java.lessons.enums.Planet;

public class WeightCalculator {
	public static void main(String[] args) {
		double mass = 100;
		for (Planet planet : Planet.values()) {
			System.out.println("On planet " + planet + " I weight " + planet.surfaceWeight(mass) / 10 + " kg");
		}
	}
}
