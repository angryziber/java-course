package net.azib.java.students.t050657.homework.dao;

import net.azib.java.students.t050657.homework.model.Competition;

import java.util.List;
/**
 * 
 * Interface for Dao for competition object.
 *
 * @author Boriss
 */
public interface CompetitionDao {

	/**
	 * Method to get competition from source 
	 * @return list of competitions
	 */
	public List<Competition> getCompetition();
}
