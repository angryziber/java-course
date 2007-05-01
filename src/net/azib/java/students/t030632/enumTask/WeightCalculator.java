package net.azib.java.students.t030632.enumTask;

import net.azib.java.lessons.enums.Planet;

import java.util.Scanner;

/**
 * WeightCalculator
 * 
 * @author Toni
 */
public class WeightCalculator {

	
	public double calculateWeightInSolarSystem(String planetName, double personMass){
		return Planet.valueOf(planetName).surfaceWeight(personMass);
	}
	
	public void iteratePlanets(double personMass){
		Object[] planets = Planet.values();
		for(Object planet: planets){
			System.out.print("on planet: "+planet.toString());
			System.out.println(" ,Your weight is: "+ calculateWeightInSolarSystem(planet.toString(), personMass));
		}
			
	}
	
	public static void main(String[] args) {
		System.out.println("Enter your mass: ");
		Scanner scanner = new Scanner(System.in);
		double personMass = Integer.parseInt(scanner.next());
		new WeightCalculator().iteratePlanets(personMass);
	}
}
