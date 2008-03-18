package net.azib.java.students.t980814.lec4;

import net.azib.java.lessons.enums.Planet;

/**
 * WeigthCalculator
 *
 * @author dell
 */
public class WeigthCalculator {

	private double weigthOnEarth;
	
	public WeigthCalculator(double weightOnEarth) {
		this.weigthOnEarth = weightOnEarth;
	}
	
	public double getWeigth(Planet planet) {
		return planet.surfaceWeight(weigthOnEarth);
	}

	public String toString() {
		StringBuilder result = new StringBuilder("The person weights: \n");
		
		for(Planet planet : Planet.values())
			result.append((int)(planet.surfaceWeight(weigthOnEarth)/9.8)).append("kg on ").append(planet.toString()).append("\n");

		return result.toString();
	}
}
