package net.azib.java.students.t030633.homework.model1;

import java.util.Date;
import java.util.EnumMap;

/**
 * Checker interface.
 *
 * @author t030633
 */
public interface Checker {
	
	String checkCountry(String country);
	
	Date checkDate(Date date);
	
	String checkName(String name);

	EnumMap<Event, Double> checkResults(EnumMap<Event, Double> results);

}
