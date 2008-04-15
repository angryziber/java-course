package net.azib.java.students.t030633.homework.model;

import java.util.Map;

/**
 * Adds scores from all events. Final score is sum of all scores from single event performances.
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