package net.azib.java.students.t040719.lessons;

import net.azib.java.lessons.enums.Planet;

/**
 * WeightCalculator
 *
 * @author Romi
 */
public class WeightCalculator {
	public static void showWeightOnAllPlanets(double weight){
		for(int i = 0; i< Planet.values().length; i++)
			System.out.println("Your weight on "+Planet.values()[i].name() + " is " + Planet.values()[i].surfaceWeight(weight) + " newtons");
	}
}
