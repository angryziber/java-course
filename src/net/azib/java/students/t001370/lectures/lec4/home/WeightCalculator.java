package net.azib.java.students.t001370.lectures.lec4.home;

import net.azib.java.lessons.enums.Planet;

/**
 * WeightCalculator
 *
 * @author maksim
 */
public class WeightCalculator {
	public static double calcWeight(Planet planet, double initMass){
		return planet.surfaceWeight(initMass);
	}
	public static double calcWeight(String planetName, double initMass){
		return Planet.valueOf(planetName).surfaceWeight(initMass);
	}

	public static void main(String[] args) {
		double mass = 70;
		
		System.out.println("==================================");
		for (Planet planet : Planet.values()) {
			System.out.println(
					"Human initial mass is - " + mass + 
					"kg. On " + planet.name() + " the weight would be - " +
					calcWeight(planet, mass) + " ::: " + calcWeight(planet.name(), mass));
		}
		System.out.println("==================================");
	}

}
