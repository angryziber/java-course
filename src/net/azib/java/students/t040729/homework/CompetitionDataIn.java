package net.azib.java.students.t040729.homework;

import java.util.List;
import java.util.Properties;

/**
 * Interface which enables competition data to be imported
 * from various sources.
 *
 * @author ValleTon
 */
public interface CompetitionDataIn {

	/**
	 * @return List of Athletes
	 * @throws Exception
	 */
	List<Athlete> getCompetitionData() throws Exception;
	
	/**
	 * Sets properties for implementations who might need them.
	 * @param properties Properties to pass for implementations
	 */
	void setAppProperties(Properties properties);
}
