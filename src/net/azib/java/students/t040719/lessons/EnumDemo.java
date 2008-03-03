package net.azib.java.students.t040719.lessons;

import net.azib.java.lessons.enums.Season;

/**
 * EnumDemo
 *
 * @author t040719
 */
public class EnumDemo {
	public static void main(String[] args){
		Season season = Season.WINTER;
		System.out.println("Before was " + season);
		season = Season.SPRING ;
		System.out.println("Now is " + season);
		if (season == Season.SPRING) {
			System.out.println("Yahoo!");
		}
		System.out.println(season.next());
	}	
}
