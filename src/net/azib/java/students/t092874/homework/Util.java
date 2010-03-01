package net.azib.java.students.t092874.homework;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Util
 * 
 * @author Aleksandr GLadki
 */
class Util {
	/**
	 * Parses String to Float from format (min:sec)
	 * 
	 * @param String
	 *            str in format (min:sec)
	 * @return Flaot
	 */
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

	/**
	 * Parses Float num to String in UI formatter 00:00
	 * 
	 * @param Float
	 *            num
	 * @return formatting String
	 */
	public static String convertNumberInSecondToString(Float num) {
		NumberFormat formatter = new DecimalFormat("00.00");
		return (num > 60 ? Integer.valueOf(num.intValue() / 60) + ":" : "")
				+ formatter.format(Float.valueOf(num % 60)).toString();

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
		if (date == null)
			return "";
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
