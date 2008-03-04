package net.azib.java.students.t030633;

import net.azib.java.lessons.enums.Planet;

/**
 * WeightCalculator
 * 
 * @author khonsu
 */
public class WeightCalculator {

	void displayWeightOnPlanets(double weight) {

		Planet planet;
		
		for (int i = 0; i < Planet.values().length; i++) {

			planet = Planet.values()[i];
			System.out.println(planet + " : " + planet.surfaceWeight(weight));
			
		}

	}

}
