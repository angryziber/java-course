package net.azib.java.students.t030633.lessons;

import net.azib.java.lessons.enums.Planet;

/**
 * EnumDemo
 * 
 * @author t030633
 */
public class EnumDemo {

	public static void main(String[] args) {

		System.out.println("Seasons:");
		// getting values
		Season season = Season.WINTER;
		System.out.println(season);

		// season can only have a value from a fixed set
		// season = 1; not possible
		// also not possible season = new Season();
		// (that would make a new Season)
		season = Season.SPRING;
		System.out.println(season);

		if (season == Season.SPRING) {
			System.out.println("--Yay!");
		}

		season = Season.values()[3];
		// same
		season = Season.valueOf("AUTUMN");

		System.out.println("Season nr. " + season.ordinal() + " is " + season);
		System.out.println("Next season is " + season.next());

		System.out.println("Planets:");
		Planet planet = Planet.EARTH;
		System.out.println(planet+"'s mass is " +planet.mass());
		
		double weight = 70;
		
		System.out.println(Planet.EARTH.surfaceWeight(weight));
		System.out.println(Planet.MARS.surfaceWeight(weight));
		
	}

}
