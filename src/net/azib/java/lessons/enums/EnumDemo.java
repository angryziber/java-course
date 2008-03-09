package net.azib.java.lessons.enums;

/**
 * EnumDemo
 *
 * @author anton
 */
public class EnumDemo {
	public static void main(String[] args) {
		Season season = Season.SPRING;
		System.out.println("Before was " + season);
		
		season = Season.AUTUMN;
		System.out.println("Now is " + season.next());
		
		String name = "Katja";
		double weight = 45;
		System.out.println(Planet.EARTH.surfaceWeightAsString(name, weight));
		System.out.println(Planet.MARS.surfaceWeightAsString(name, weight));
	}
}
