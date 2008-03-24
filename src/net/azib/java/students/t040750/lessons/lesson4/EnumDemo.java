package net.azib.java.students.t040750.lessons.lesson4;

import net.azib.java.lessons.enums.Planet;

/**
 * EnumDemo
 *
 * @author t040750
 */
public class EnumDemo {
	public static void main(String[] args) {
		Season season = Season.WINTER;
		System.out.println("Before was " + season);
		/*
		season = Season.SPRING;
		System.out.println("Now is " + season);
		
		if (season == Season.SPRING) {
			System.out.println("Summer is coming");
		}
		*/
		season = Season.SPRING;
		System.out.println("Now is " + season.next());
		
		season = Season.AUTUMN;
		season = Season.valueOf("AUTUMN");
		System.out.println(season.ordinal());
		
		String name = "Katja";
		double weight = 45;
		//System.out.println(Planet.EARTH.surfaceWeightAsString(name,weight));
		System.out.println(Planet.MARS.surfaceWeight(weight));
		
		
	}
}
