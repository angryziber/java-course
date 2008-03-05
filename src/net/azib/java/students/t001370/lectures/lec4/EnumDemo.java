package net.azib.java.students.t001370.lectures.lec4;

import net.azib.java.lessons.enums.Planet;
import net.azib.java.lessons.enums.Season;

/**
 * EnumDemo
 *
 * @author maksim
 */
public class EnumDemo {

	public static void main(String[] args) {

		Season season = Season.WINTER;
		System.out.println("Before was " + season);
		season = Season.SPRING;
		
		//season = 1; ei ole lubatud
		//season = new Season();
		
		System.out.println("Now is " + season);
		System.out.println("Next is " + season.next());
		
		/*if (season == Season.SPRING) {
			System.out.println("Yahhoo!");
		} */
		
		//season = Season.valueOf("AUTUMN");
		season = Season.values()[3];
		System.out.println(season.ordinal());
		
		
		Planet planet = Planet.EARTH;
		System.out.println(planet.mass());
		double weight = 45;
		System.out.println(planet.EARTH.surfaceWeight(weight));
		System.out.println(planet.MARS.surfaceWeight(weight));
		
	}

}
