package net.azib.java.students.t030633.homework.Model;

import java.util.EnumMap;

/**
 * Adds scores from all events.
 * 
 * @author t030633
 */
public class AddingCalculator implements Calculator {

	/**
	 * @param Results to calculate score from
	 * @return calculated score
	 */
	public int calculate(EnumMap<Event, Double> results) {
		int score = 0;
		// iterate over events and add scores
		for (Event e : results.keySet()) {
			score += e.points(results.get(e));
		}
		return score;
	}

}