 package net.azib.java.students.t654321.lectures.lecture4;

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
		System.out.println("Now is " + season.WINTER.next());
		
		String name = "Karl";
		double weight = 85;
//		System.out.println(Planet.EARTH.surfaceWeightAsString(name, weight));
//		System.out.println(Planet.MARS.surfaceWeightAsString(name, weight));
        for (Planet p : Planet.values()) {
            System.out.println(p.surfaceWeightAsString(name, weight));
        }
	}
}
