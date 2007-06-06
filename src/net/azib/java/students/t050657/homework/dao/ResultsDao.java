package net.azib.java.students.t050657.homework.dao;

import net.azib.java.students.t050657.homework.model.Competition;

/**
 * Interface for Dao for results object.
 *
 * @author Boriss
 */
public interface ResultsDao {
	public Competition getCompetitionResults(Competition competition);
}
