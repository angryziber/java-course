package net.azib.java.students.t110051.Lesson5;

import antlr.collections.Enumerator;
import net.azib.java.lessons.enums.Planet;

import java.util.Enumeration;

public class WeightCalculator {
	public static final double G = 9.80665;
	public static final int weight = 110;

	public static void main(String[] args) {

		for (Planet planet : Planet.values()) {
			System.out.println("My mass on " + planet + " is " + new WeightCalculator().calculateWeight(planet, weight) + " kg.");

		}
	}

	public double calculateWeight(Planet planet, double weight) {
		 return Math.round(planet.surfaceWeight(weight/G)) ;
	}

}
