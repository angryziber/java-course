package net.azib.java.students.t040771.lessons;

import net.azib.java.lessons.enums.Season;

/**
 * EnumDemo
 *
 * @author t040771
 */
public class EnumDemo {
	public static void main(String[] args) {
		Season season = Season.WINTER;
		System.out.println(season);
		
		season = Season.SPRING;
		System.out.println(season);
		
		if (season == Season.SPRING) { //For enums there is always only one instance and we can compare references
			System.out.println("Summer is coming!");
		}
		
		System.out.println(season.next() + " is coming!");
		
	}
}
