package net.azib.java.students.t050657.homework.dao;

import java.sql.Date;

import net.azib.java.students.t050657.homework.model.Competition;
/**
 * 
 * Interface for Dao for competition object.
 *
 * @author Boriss
 */
public interface CompetitionDao {

	public Competition getCompetition(String countryCode, Date date, String description);
}
