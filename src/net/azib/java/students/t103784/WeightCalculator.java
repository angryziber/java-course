package net.azib.java.students.t103784;

import net.azib.java.lessons.enums.Planet;

/**
 * Created by IntelliJ IDEA.
 * User: Ott Madis Ozolit
 * Date: 16.03.11
 * Time: 23:19
 * To change this template use File | Settings | File Templates.
 */
public class WeightCalculator {

	public static final int myWeight = 80;
	public static final double g = Planet.EARTH.surfaceGravity();

	public static void main(String[] args) {
		for (Planet planet : Planet.values()) {
			System.out.println("I weigh: " + Math.round((planet.surfaceWeight(myWeight)) / g) + "kg on " + planet);
		}

	}
}
