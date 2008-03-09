package net.azib.java.students.t654321.hometasks;

import net.azib.java.lessons.enums.Planet;

/**
 * WeightCalculator
 *
 * @author Karl
 */
public class WeightCalculator {
	public static void main(String[] args) {
		Planet[] planets = Planet.values();
		Double myweight = Double.parseDouble(args[0]);
		for(Planet p: planets){
			Double myweightonplanet = p.surfaceWeight(myweight);
			System.out.println("My weight on planet" + p + " is "+ myweightonplanet + " N");
		}
	}
}
