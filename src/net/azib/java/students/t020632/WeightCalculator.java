package net.azib.java.students.t020632;

import net.azib.java.lessons.enums.Planet;

/**
 * WeightCalculator
 *
 * @author t020632
 */
public class WeightCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please provide weight of the body on Earth as a command-line argument");
			return;
		}
		
		String stringWeight = args[0];
		int weight = Integer.parseInt(stringWeight);
		double m = weight/Planet.EARTH.surfaceGravity();
		
		for (Planet planet : Planet.values()) {
			System.out.println("Weight on "+ planet + " is " + planet.surfaceWeight(m));
		}
		

	}

}
