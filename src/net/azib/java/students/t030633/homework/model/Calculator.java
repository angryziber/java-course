package net.azib.java.students.t030633.homework.model;

import java.util.Map;

/**
 * Calculator interface.
 * 
 * @author t030633
 */
public interface Calculator {

	/**
	 * @param results - Map, results (event performances)
	 * @return int - score calculated from results
	 */
	int calculate(Map<Event, Double> results);

}
