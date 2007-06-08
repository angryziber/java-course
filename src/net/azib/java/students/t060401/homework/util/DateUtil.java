package net.azib.java.students.t060401.homework.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Contains a selection of utility methods for managing dates.
 * 
 * @author t060401
 */
public class DateUtil {

	private static String DATE_FORMAT = "dd.MM.yyyy";
	
	/**
	 * Parses given string according to the specified date format to produce a date
	 * 
	 * @param dateString string to parse
	 * @return returns date parsed from string
	 * @throws IllegalArgumentException
	 */
	public static Date getDate(String dateString) throws IllegalArgumentException {
		Date date = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
			format.setLenient(false);
			date = format.parse(dateString);
		}
		catch (Exception e) {
			throw new IllegalArgumentException("Illegal date format. Correct format is "+DATE_FORMAT, e);
		}
		return date;
	}

	/**
	 * Generates date string from given Date object
	 * 
	 * @param date date to format
	 * @return returns String generated from Date
	 */
	public static String getDateAsString(Date date) {
		//System.out.println("date " + date);
		String dateString = null;
		if (date != null) {
			dateString = new SimpleDateFormat(DATE_FORMAT).format(date);
		}
		return dateString;
	}
}
