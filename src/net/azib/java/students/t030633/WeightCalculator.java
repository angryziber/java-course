package net.azib.java.students.t030633;

import net.azib.java.lessons.enums.Planet;

// import java.util.Scanner;

/**
 * WeightCalculator
 * 
 * @author t030633
 */
public class WeightCalculator {

	void displayWeightOnPlanets(double weight) {

		Planet planet;

		for (int i = 0; i < Planet.values().length; i++) {

			planet = Planet.values()[i];
			System.out.println(planet + "\t: " + planet.surfaceWeight(weight));

		}

	}

	// public static void main(String[] args) {
	// WeightCalculator w = new WeightCalculator();
	// Scanner scanner = new Scanner(System.in);
	// w.displayWeightOnPlanets(scanner.nextInt());
	// }

}
