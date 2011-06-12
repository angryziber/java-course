package net.azib.java.students.t100224.homework.io;

import net.azib.java.students.t100224.homework.model.Result;

import java.util.List;

public interface ResultsLoader {
	/**
	 * Load input data from specific source
	 *
	 * @return - Array list of athletes and their decathlon results
	 */
	public List<Result> loadResults(String param);

}
