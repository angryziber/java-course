package net.azib.java.students.t020281.loeng4;

import net.azib.java.lessons.enums.Season;
import net.azib.java.lessons.enums.Planet;

/**
 * EnumDemo
 *
 * @author Trial
 */
public class EnumDemo {
	
public static void main(String[] args) {
	Season season = Season.WINTER;
	System.out.println("Before was " + season);
	season = Season.SPRING;
	System.out.println("Now is " + season);
	
	if (season == Season.SPRING) {
		System.out.println("Yoohoo!");
	}
	
	season = Season.values()[3];
	System.out.println("Next is " + season.next());
	System.out.println("Ordinal is " + season.ordinal());
	
	Planet planet = Planet.EARTH;
	System.out.println(planet.mass());
	
	double weight = 70;
	System.out.println(Planet.EARTH.surfaceWeight(weight));
	System.out.println(Planet.MARS.surfaceWeight(weight));
	
}
}
