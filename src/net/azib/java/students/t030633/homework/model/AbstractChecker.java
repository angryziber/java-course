package net.azib.java.students.t030633.homework.model;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 * Checks for logical correctness in Athlete fields and removes null values.
 *
 * @author t030633
 */
public abstract class AbstractChecker implements Checker {

	public String checkCountry(String country) {
		if (country == null) return "";
		else if (Arrays.binarySearch(Locale.getISOCountries(), country) > 0)
			return country;
		else
			return "";
	}

	public Date checkDate(Date date) {
		if (date == null)
			return new Date();
		else
			return date;
	}

	public String checkName(String name) {
		if (name == null)
			return "";
		else
			return name;
	}

}
