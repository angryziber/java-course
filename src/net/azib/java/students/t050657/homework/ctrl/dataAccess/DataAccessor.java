package net.azib.java.students.t050657.homework.ctrl.dataAccess;

import net.azib.java.students.t050657.homework.model.Competition;

import java.sql.Date;

/**
 * DataAccessor
 *
 * @author Boriss
 */
public interface DataAccessor {
	
	public Competition getCompetition(String countryCode, Date date, String description);
	
}
