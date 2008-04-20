package net.azib.java.students.t072054.hometask1;

import net.azib.java.lessons.enums.Planet;
import java.io.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * WeightCalculator
 * 
 * @author Roman
 */
public class WeightCalculator {
	public static void main(String[] args) {
		Planet pl;
		String string = "";
		double weight;

		System.out.println("Enter your weight...");

		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);

		try {

			string = reader.readLine();

		}
		catch (Exception e) {
		}
		/*
		 * 
		 * @weight - this your weight on the Earth
		 */
		weight = Integer.parseInt(string);

		double earth_mass = weight / Planet.EARTH.surfaceGravity();
		for (Planet p : Planet.values()) {
			System.out.printf("Your weight on %s is %f%n", p, p.surfaceWeight(earth_mass));
			System.out.println(p.surfaceWeightAsString(p.name(), p.surfaceWeight(earth_mass)));
		}
	}

}
