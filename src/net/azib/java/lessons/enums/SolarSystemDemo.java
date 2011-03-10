package net.azib.java.lessons.enums;

public class SolarSystemDemo {
	public static void main(String[] args) {
		Planet planet = Planet.MARS;
		double mass = 42;
		System.out.println("On planet " + planet + " I weight " + planet.surfaceWeight(mass) / 10 + " kg");
	}
}
