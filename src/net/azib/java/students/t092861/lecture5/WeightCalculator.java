package net.azib.java.students.t092861.lecture5;

import net.azib.java.lessons.enums.Planet;

/**
 * @author Stanislav / 092861
 * 
 */
public class WeightCalculator {
	public static final int MY_WEIGHT = 85;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int devider = 10;

		for (Planet curPlanet : Planet.values()) {
			System.out.println("My weight on " + curPlanet + " is "
					+ (int)curPlanet.surfaceWeight(MY_WEIGHT) + " kg");
		}
		
/*		Correct results must be:
			Меркурий	32.1 кг
			Венера		77 кг
			Луна		14.1 кг
			Марс		32 кг
			Юпитер		200.9 кг
			Сатурн		77.8 кг
			Уран		75.5 кг
			Нептун		95.6 кг
			Плутон		5.6 кг */
	}

}
