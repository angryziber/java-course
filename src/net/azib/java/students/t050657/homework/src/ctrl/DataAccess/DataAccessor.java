package net.azib.java.students.t050657.homework.src.ctrl.DataAccess;

import net.azib.java.students.t050657.homework.src.model.Competition;

import java.sql.Date;

/**
 * DataAccessor
 *
 * @author Boriss
 */
public interface DataAccessor {
	
	public Competition getCompetition(String countryCode, Date date, String description);
	
}
