package net.azib.java.students.t030633.homework.model;

import java.util.Date;
import java.util.EnumMap;

/**
 * Checker interface.
 *
 * @author t030633
 */
public interface Checker {
	
	/**
	 * @param country - String, country code
	 * @return String - country if valid according to ISO 3166-1 alpha-2, empty string if not or code was null
	 */
	public String checkCountry(String country);
	
	/**
	 * @param date - Date, could be null
	 * @return Date
	 */
	public Date checkDate(Date date);
	
	/**
	 * @param name - String, could be null
	 * @return String - name, if name was null then empty string
	 */
	public String checkName(String name);

	/**
	 * @param results - EnumMap, results from a competition in Map format
	 * @return EnumMap - results checked for logical correctness
	 */
	public EnumMap<Event, Double> checkResults(EnumMap<Event, Double> results);

}
