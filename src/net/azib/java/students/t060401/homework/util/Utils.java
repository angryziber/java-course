package net.azib.java.students.t060401.homework.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Utils class contains a selection of utility methods.
 * 
 * @author t060401
 */
public class Utils {

	
	/**
	 * Parses given string according to specified date format to produce a date
	 * 
	 * @param dateString string to parse
	 * @return returns date parsed from string
	 * @throws Exception
	 */
	public static Date getDate(String dateString) throws Exception {
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
		format.setLenient(false);
		//System.out.println(" parsin " + dateString);
		date = format.parse(dateString);
		//System.out.println(" parsin date " + date);
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
			dateString = new SimpleDateFormat(Constants.DATE_FORMAT).format(date);
		}
		return dateString;
	}

	/**
	 * Generates date string from Calendar object
	 * 
	 * @param date Calendar object to parse
	 * @return returns string generated from Calendar
	 */
	public static String getDateAsString(Calendar date) {
		Date time = date.getTime();
		String dateString = null;
		dateString = getDateAsString(time);
		return dateString;
	}

	/**
	 * Separates minutes from seconds value and adds both to a string using format mm:ss.ss
	 * 
	 * @param seconds to parse
	 * @return returns time string with format mm:ss.ss
	 */
	public static String getTimeString(double seconds) {
		DecimalFormat df = new DecimalFormat("00.00");
		String timeString = df.format(seconds);
		int minutes = (int)seconds/60;
		double residue = seconds%60;
		if (minutes != 0)
			timeString = minutes+":"+df.format(residue);
		return timeString;
	}
	
	/**
	 * Converts double value to string with format mm.mm
	 * 
	 * @param meters to parse
	 * @return returns distance string with format mm.mm
	 */
	public static String getDistanceString(double meters) {
		DecimalFormat df = new DecimalFormat("0.00");
		String distanceString = df.format(meters);
		return distanceString;
	}
	
	/**
	 * Extracts minutes from time string. Minutes value is separated from seconds with ':'.
	 * 
	 * @param timeString to parse
	 * @return returns minutes
	 * @throws IllegalArgumentException
	 */
	public static int extractMinutes(String timeString) throws IllegalArgumentException {
		int minutes = 0;
		if (timeString == null || "".equals(timeString)) {
			throw new IllegalArgumentException("Time value cannot be empty");
		}
		String[] timeArray = timeString.split(Constants.MINUTES_DELIMITER);
		//System.out.println(timeString + " length " + timeArray.length);
		if (timeArray.length == 2) {
			try {
				minutes = Integer.parseInt(timeArray[0]);
			}
			catch (NumberFormatException e) {
				throw new IllegalArgumentException("Illegal minutes value: " + timeArray[0], e);
			}
		}
		return minutes;
	}

	/**
	 * Returns seconds value extracted from time string. Seconds value is separated from minutes with ':'.
	 * 
	 * @param timeString to parse
	 * @return returns seconds
	 * @throws IllegalArgumentException
	 */
	public static double extractSeconds(String timeString) throws IllegalArgumentException {
		double seconds = 0;
		if (timeString == null || "".equals(timeString)) {
			throw new IllegalArgumentException("Time value cannot be empty");
		}
		String[] timeArray = timeString.split(Constants.MINUTES_DELIMITER);
		int lastIndex = timeArray.length - 1;
		try {
			seconds = Double.parseDouble(timeArray[lastIndex]);
		}
		catch (Exception e) {
			throw new IllegalArgumentException("Illegal seconds value: " + timeArray[lastIndex], e);
		}
		return seconds;
	}

	/**
	 * Converts meters to centimeters.
	 * 
	 * @param meters
	 * @return returns centimeters
	 */
	public static int parseMetersToCm(double meters) {
		int intPart = (int) meters;
		double fracPart = meters - intPart;
		return intPart * 100 + (int) Math.round(fracPart * 100);
	}
}
