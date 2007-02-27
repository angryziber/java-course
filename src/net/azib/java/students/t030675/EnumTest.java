package net.azib.java.students.t030675;

import net.azib.java.lessons.misc.Planet;
import net.azib.java.lessons.misc.Season;

/**
 * EnumTest
 *
 * @author t030675
 */
public class EnumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Season.WINTER.next());
		System.out.println(Planet.EARTH.surfaceWeight(100));
	}

}
