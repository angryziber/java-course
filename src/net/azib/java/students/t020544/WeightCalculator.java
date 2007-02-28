package net.azib.java.students.t020544;

import net.azib.java.lessons.enums.Planet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * WeightCalculator
 * 
 * @author Julija Kondratjeva
 */
public class WeightCalculator {

	public static double getWeight() throws Exception, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("For what mass do You want to know the answer?");
		double weight = Double.parseDouble(in.readLine());
		return weight;
	}

	/**
	 * @param args
	 * @throws Exception
	 * @throws IOException
	 * @throws Exception
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, Exception {

//		Planet[] planets = Planet.values();
		System.out.println("The program calculates weight on Solar System's planets.");
		double m = getWeight();

		if (m < 0) {
			System.out.println("Answer doesn't exist. Mass > 0.");
		}

		else {
			 for (Planet planets : Planet.values()) {
//			for (int i = 1; i < planets.length; i++) {
				System.out.println("For " + m + " kg weight on " + planets+ " is " + (int) planets.surfaceWeight(m)
						+ " N.");

			}

		}
	}
}
