package net.azib.java.lessons.enums;

/**
 * PlanetsDemo
 *
 * @author anton
 */
public class PlanetsDemo {
	public static void main(String[] args) {
		Planet planet = Planet.valueOf("MARS");
		
		System.out.println("On " + planet + " I would weight " + 
				planet.surfaceWeight(70));
	}
}
