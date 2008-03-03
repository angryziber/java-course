package net.azib.java.students.t654321;

import net.azib.java.lessons.basic.Todo;
import net.azib.java.lessons.enums.Planet;

/**
 * EnumDemo
 *
 * @author t999902
 */
@Todo("Commit your work")
@Deprecated
public class EnumDemo {
	public static void main(String[] args) {
		Season season = Season.WINTER;
		System.out.println("Before was " + season);
		
		//season = Season.SPRING;
		//season =  Season.valueOf("AUTUMN");
		//System.out.println(season.ordinal());
		//season = Season.values()[3];
		
		System.out.println("Now is " + season.next());
	
		// Planets
		
		Planet planet = Planet.EARTH;
		double weight = 80;
		System.out.println("Your weight on " + planet + " is " + planet.surfaceWeight(weight));
		System.out.println("Your weight on MARS is " + Planet.MARS.surfaceWeight(weight));
		//System.out.println(Planet.MARS.surfaceWeight(weight));
	}
	
}
