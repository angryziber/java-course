package net.azib.java.students.t040729.homework;

import java.util.List;
import java.util.Properties;

/**
 * Interface which provides the ability of outputting
 * competition results in various forms.
 *
 * @author ValleTon
 */
public interface CompetitionDataOut {
	/**
	 * @param a List of athletes to be outputted
	 * @throws Exception
	 */
	void putCompetitionData(List<Athlete> athlete) throws Exception;
	
	/**
	 * Sets properties for implementations who might need them.
	 * @param properties Properties to pass for implementations
	 */
	void setAppProperties(Properties properties);
}
