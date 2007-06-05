package net.azib.java.students.t020543.homework;

import java.util.List;


/**
 * An interface for a {@link DataAccessor} class
 * @author t020543
 */
public interface IDataAccessor {
	
	/**
	 * Creates connection to the database, using driver and link
	 * @param url - link to the databse
	 */
	public abstract void initializeConnection(String url);
	
	/**
	 * Closes connection to the databse
	 */
	public abstract void releaseConnection();

	/**
	 * Reads {@link CompetitionTest} data from the database
	 * @return list of competitions
	 */
	public abstract List<Competition> makeQueryForCompetition();
	
	/**
	 * Reads {@link Athlete} data from the database
	 * @param choice - selected competition (selected by user)
	 * @return list of {@link Athlete} objects
	 */
	public abstract List<Athlete> makeQueryForAthlete(int choice);
}
