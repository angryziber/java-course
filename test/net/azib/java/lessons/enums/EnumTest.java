package net.azib.java.lessons.enums;

import net.azib.java.lessons.enums.Planet;


/**
 * EnumTest
 *
 * @author anton
 */
public class EnumTest {
	public static void main(String[] args) {
		Planet planet = Planet.PLUTO;
		
		System.out.println(planet.surfaceWeight(100));
	}
}
