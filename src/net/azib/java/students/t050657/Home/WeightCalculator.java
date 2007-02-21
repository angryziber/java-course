package net.azib.java.students.t050657.Home;

import net.azib.java.simple.Planet;

/**
 * WeightCalculator
 * @author t050657
 */
public class WeightCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(Planet planet : Planet.values()) {
			double weight = planet.surfaceWeight(65);
			System.out.println("On the " + planet + " = " + (int)weight);
		}
	}
}
