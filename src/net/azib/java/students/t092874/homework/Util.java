package net.azib.java.students.t092874.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Util
 * 
 * @author Aleksandr GLadki
 */
class Util {

	public static Float convertStringToNumberInSecond(String str) {
		try {
			if (str.contains(":")) {
				return Float.valueOf(str.substring(0, str.lastIndexOf(":"))) * 60
						+ Float.valueOf(str.substring(str.lastIndexOf(":") + 1));
			}
			else {
				return Float.valueOf(str);
			}
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Float convertStringToNumberInMeter(String str) {
		try {
			if (str.contains(":")) {
				return Float.valueOf(str.substring(0, str.lastIndexOf(":"))) * 100
						+ Float.valueOf(str.substring(str.lastIndexOf(":") + 1));
			}
			else {
				return Float.valueOf(str);
			}
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Parses text from the beginning of the given string to produce a date.
	 * 
	 * @param source
	 *            String whose beginning should be parsed.
	 * @return A Date parsed from the string.
	 * @exception ParseException
	 *                if the beginning of the specified string cannot be parsed.
	 */
	public static Date convertStringToDate(String str) {

		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		try {
			return formatter.parse(str);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Formats a Date into a date/time string.
	 * 
	 * @param date
	 *            the time value to be formatted into a time string.
	 * @return the formatted time string.
	 */
	public static String convertDateToString(Date date) {
		if ( date == null)
			return"00-00-0000";
		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		return formatter.format(date);
	}

	/**
	 * @param source
	 *            String, from it get the path
	 *@return the path as string if it exist.
	 */
	public static String getDirFromString(String str) {
		return str.substring(0, str.lastIndexOf("/"));
	}
}
