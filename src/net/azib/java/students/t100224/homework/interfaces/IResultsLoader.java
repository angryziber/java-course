package net.azib.java.students.t100224.homework.interfaces;

import net.azib.java.students.t100224.homework.model.Result;

import java.util.List;

public interface IResultsLoader {
	/**
	 * Load input data from specific source
	 *
	 * @return - Array list of athletes and their decathlon results
	 */
	public List<Result> loadResults();

}
