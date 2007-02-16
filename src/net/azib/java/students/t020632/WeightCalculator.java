package net.azib.java.students.t020632;

import net.azib.java.simple.Planet;

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
		// TODO Auto-generated method stub
		String stringWeight = args[0];
		Planet [] planets = Planet.values();
		int weight = Integer.parseInt(stringWeight);
		int i = 0;
		double m = weight/Planet.EARTH.surfaceGravity();
		
		while(i < planets.length){
			System.out.println("Weight on "+ planets[i] + " is " + planets[i].surfaceWeight(m));
			i++;
		}
		

	}

}
