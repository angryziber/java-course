package net.azib.java.students.t030629.hometasks.ht4;

import net.azib.java.lessons.enums.Planet;

/**
 * WeightCalculator
 *
 * @author anton_chepurov
 */
public class WeightCalculator {
	
	public static void display(String name, double mass){
		for (Planet planet : Planet.values()){
			System.out.println(planet.surfaceWeightAsString(name, mass));
		}
	}

	public static void main(String[] args) {
		
		double mass = 64;
		String name = "Borja";
		
		WeightCalculator.display(name, mass);
		
	}

}
