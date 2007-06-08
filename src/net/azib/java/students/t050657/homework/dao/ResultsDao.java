package net.azib.java.students.t050657.homework.dao;

import net.azib.java.students.t050657.homework.model.Competition;

/**
 * Interface for Dao for results object.
 *
 * @author Boriss
 */
public interface ResultsDao {
	/**
	 * Method to fill competition by results from source
	 * @param competition to fill
	 * @return competition with results
	 */
	public Competition getCompetitionResults(Competition competition);
}
