package net.azib.java.lessons.enums;

/**
 * EnumDemo
 *
 * @author anton
 */
public class EnumDemo {
	public static void main(String[] args) {
		Season season = Season.SPRING;
		System.out.println("Before was " + season + " (" + season.ordinal() + ")");
		
		System.out.println("Now is " + season.next());
		Season.AUTUMN.next();
		
		String name = "Karl";
		double weight = 85;		
		for (Planet p : Planet.values()) {
			System.out.println(p.surfaceWeightAsString(name, weight));
		}
	}
}
