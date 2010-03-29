package net.azib.java.students.t073639.taskAggregation;

import net.azib.java.lessons.enums.Planet;

/**
 * WeightCalculator
 * 
 * @author t073639
 */
public class WeightCalculator {
	public static void main(String[] args) {
		for (Planet p : Planet.values()) {
			System.out.println("On "+p.name()+", I would weight "+p.surfaceWeight(80.1));
		}
	}

}
