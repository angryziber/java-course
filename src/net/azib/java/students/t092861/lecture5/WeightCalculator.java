package net.azib.java.students.t092861.lecture5;

import net.azib.java.lessons.enums.Planet;

/**
 * @author Stanislav / 092861
 * 
 */
public class WeightCalculator {
	public static final int MY_MASS = 85;
	public static final double G = 9.80665;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (Planet curPlanet : Planet.values()) {
			System.out.format("My weight on %s is %5.2f kg%n", curPlanet, new WeightCalculator().calculateWeight(curPlanet, MY_MASS));
		}
	}
	
	public double calculateWeight(Planet planet, double mass) {
		return planet.surfaceWeight(mass)/G;
	}

}
