package net.azib.java.students.t030633.homework.model;

import java.util.Map;

/**
 * Calculates final score by adding scores from all events.
 * 
 * @author t030633
 */
public class AddingCalculator implements Calculator {

	public int calculate(Map<Event, Double> results) {
		int score = 0;
		// iterate over events and add scores
		for (Event e : results.keySet()) {
			score += e.points(results.get(e));
		}
		return score;
	}

}