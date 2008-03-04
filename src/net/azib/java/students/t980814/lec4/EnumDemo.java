package net.azib.java.students.t980814.lec4;

import net.azib.java.lessons.enums.Planet;
import net.azib.java.lessons.enums.Season;

/**
 * EnumDemo
 *
 * @author dell
 */
public class EnumDemo {

	 public static void main(String[] args) {
		Season season = Season.WINTER;
		System.out.println("Before was " + season);
		season = Season.SUMMER;
		System.out.println("Soon will be " + season);
		
		if (season == Season.SUMMER)
			System.out.println("OK");
		
		System.out.println("After summer there will be " + season.next());
		
		
		Planet planet = Planet.EARTH;
		System.out.println(planet.mass());
		
		double weight = 98;
		System.out.println("On earth: " + (int)(Planet.EARTH.surfaceWeight(weight)/9.8) + "kg");
		System.out.println("On mars: " + (int)(Planet.MARS.surfaceWeight(weight)/9.8) + "kg");
		System.out.println("On jupiter: " + (int)(Planet.JUPITER.surfaceWeight(weight)/9.8) + "kg");
	}
}
