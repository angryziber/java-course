package net.azib.java.students.t030520.homework.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Help class for operating with numbers, dates and strings.
 *
 * @author t030520
 */
public class Utils {

	/**
	 * @param str the string to control.
	 * @return true is the str is null or empty.
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	/**
	 * @param str the string to control.
	 * @return true if the str is valid date.
	 */
	public static boolean isValidDate(String str) {
		try {
			convertToDate(str);
		} catch (RuntimeException e) {
			return false;
		}

		return true;
	}

	/**
	 * @param str to convert.
	 * @return converted date.
	 */
	public static Date convertToDate(String str) {
		try {
			DateFormat formater = new SimpleDateFormat("dd.mm.yyyy");
			return formater.parse(str);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param str to control.
	 * @return true if the str is valid float number.
	 */
	public static boolean isValidFloat(String str) {
		try {
			convertToFloat(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * @param str to control.
	 * @return true if the str is valid long number.
	 */
	public static boolean isValidLong(String str) {
		try {
			Long.valueOf(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * @param str to convert.
	 * @return converted string.
	 */
	public static long convertToLong(String str) {
		try {
			return Long.valueOf(str);
		} catch (NumberFormatException e) {
			throw e;
		}
	}

	/**
	 * @param str to convert.
	 * @return converted float.
	 */
	public static float convertToFloat(String str) {
		try {
			String[] numbers = str.split(":");
			if (numbers.length == 2) {
				return Integer.valueOf(numbers[0]) * 60 + Float.valueOf(numbers[1]);
			} else {
				return Float.valueOf(str);
			}
		} catch (NumberFormatException e) {
			throw e;
		}
	}
}
