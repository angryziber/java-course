package net.azib.java.students.t030633.homework.model;

import java.util.Map;

/**
 * Calculates a score from results.
 * 
 * @author t030633
 */
public interface Calculator {

	/**
	 * @param results - Map, results (event performances)
	 * @return int - integer score calculated from results
	 */
	int calculate(Map<Event, Double> results);

}
