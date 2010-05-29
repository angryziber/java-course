package net.azib.java.students.t092859.hometask5;

import net.azib.java.lessons.enums.Planet;

import java.util.Scanner;

/**
 * WeightCalculator
 *
 * @author kostya
 */
public class WeightCalculator {
	
	/*
	 * calculates mass which on Earth corresponds to the same pulling force,
	 * as provided mass on provided planet
	 * @param planet - planet pulling the mass
	 * @return corresponding mass in kilograms on Earth
	 */
	public double calcEarthMass (Planet planet, double mass){
		return planet.surfaceWeight(mass) / 9.8;
	}

	public static void main(String[] args) {
		WeightCalculator calculator = new WeightCalculator();
		
		System.out.print("Provide your mass on Earth (kg): ");
		Scanner in = new Scanner(System.in);
		double providedMass = in.nextDouble();
		
		System.out.println("Choose planet:");
		for(Planet planet : Planet.values())
			System.out.println("\t" + planet.ordinal() + " " + planet.name());
		
		Planet providedPlanet = Planet.values()[in.nextInt()];
		
		System.out.print("Pulling force (in Earth kilograms) on planet " + 
				providedPlanet.name() + " = ");
		System.out.format("%.2fkg", calculator.calcEarthMass(providedPlanet, providedMass));
	}
	
}
