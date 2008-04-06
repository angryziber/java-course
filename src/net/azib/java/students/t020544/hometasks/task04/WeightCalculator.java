package net.azib.java.students.t020544.hometasks.task04;

import net.azib.java.lessons.enums.Planet;

/**
 * WeightCalculator
 * 
 * @author Julija Kondratjeva
 */
public class WeightCalculator {

	public void displayWeight(double weightOnEarth) {
		Planet[] planet = Planet.values();
		for (Planet p : planet) {
			System.out.println("Weight on " + p + " " + p.surfaceWeight(weightOnEarth));

		}

	}

	public static void main(String[] args) {
		WeightCalculator wk = new WeightCalculator();
		wk.displayWeight(55);
	}

}
