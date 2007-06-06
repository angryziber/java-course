package net.azib.java.students.t050657.homework.ctrl.dataAccess;

import net.azib.java.students.t050657.homework.model.Competition;

import java.sql.Date;

/**
 * DataAccessor interface between service tier and data tier in application.
 *
 * @author Boriss
 */
public interface DataAccessor {
	/**
	 * Gets a Competition instance from data-tier. 
	 * @param countryCode
	 * @param date
	 * @param description
	 * @return new comprtition 
	 */
	public Competition getCompetition(String countryCode, Date date, String description);
	
}
