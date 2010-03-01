package net.azib.java.lessons.enums;

/**
 * SeasonDemo
 *
 * @author anton
 */
public class SeasonDemo {
	public static void main(String[] args) {
		Season s = Season.WINTER;
		System.out.println("Yesterday was " + s.name() + ", now is " + s.next());
		
		for (Season season : Season.values()) {
			System.out.println(season + " has ordinal of " + season.ordinal() + 
					", the next one is " + season.next());
		}
	}
}
