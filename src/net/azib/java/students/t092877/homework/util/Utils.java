package net.azib.java.students.t092877.homework.util;

import net.azib.java.students.t092877.homework.model.Athlete;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utils.java
 * Purpose: contains several useful methods for athletes list sorting and values format conversion
 *
 * @author Artjom Kruglenkov / 092877
 * @version 1.2 24.05.2011
 */
public class Utils {

	/**
	 * Sorts athletes in descending order based on their total score and sets each athlete's place in the competition.
	 *
	 * @param athletes a list of athletes
	 */
	public static void sortAthletes(List<Athlete> athletes) {

		if (athletes == null) {
			System.err.println("\n>>> ERROR: the list provided for sorting is empty");
			System.exit(1);
		}

		Collections.sort(athletes);
		Map<String, int[]> spans = new HashMap<String, int[]>();

		int spanToken = 1;

		for (Athlete athlete : athletes) {

			setSpan(spans, athlete, spanToken);
			spanToken++;
		}

		for (Athlete athlete : athletes) {

			String place = getSpan(spans, athlete);
			athlete.setPlace(place);
		}
	}


	public static void setSpan(Map<String, int[]> spans, Athlete athlete, int spanToken) {

		int[] span = spans.get(Integer.toString(athlete.getTotalScore()));

		if (span == null){
			spans.put(Integer.toString(athlete.getTotalScore()), new int[]{spanToken, spanToken});
		} else {
			span[1] = spanToken;
		}
	}


	public static String getSpan(Map<String, int[]> spans, Athlete athlete) {

		int[] span = spans.get(Integer.toString(athlete.getTotalScore()));

		if(span == null) {
			throw new RuntimeException("No entry in the list...");
		}

		if (span[0] == span[1]) {
			return Integer.toString(span[0]);
		} else {
			return span[0] + "-" + span[1];
		}
	}


	/**
	 * Converts result value from original format to internal representation.
	 *
	 * @param value the result value in the provided format
	 * @param type the type of an event
	 * @return the result value in its internal format
	 */
	public static double convertToProperUnits(String value, String type) {

		double properValue = 0;
		String[] originalValue = value.split(":");

		// athlete's performance measured in centimeters for jumping events
		if (type.equals("jumping"))	{
			properValue = Double.parseDouble(originalValue[0]) * 100;

		// athlete's performance measured in seconds for running events
		} else if (type.equals("running")) {

			if (originalValue.length == 2)
				properValue = Double.parseDouble(originalValue[0]) * 60 + Double.parseDouble(originalValue[1]);

			else
				properValue = Double.parseDouble(originalValue[0]);
		// athlete's performance measured in meters for throwing events
		} else
			properValue = Double.parseDouble(originalValue[0]);
		return properValue;
	}


	/**
	 * Converts result value from internal representation to original format.
	 *
	 * @param value the result value in its internal format
	 * @param type the type of an event
	 * @return the result value in its original format
	 */
	public static String convertToOriginalUnits(double value, String type) {

		String originalUnits = "";

		if (type.equals("jumping")) {
			originalUnits = String.valueOf(value / 100.0);

		} else if (type.equals("running")) {
			int minutes = (int) (value / 60);
			double seconds = Math.round(value % 60 * 100) / 100.0;

			if (value >= 60)
				originalUnits = String.valueOf(minutes) + ":" + String.valueOf(seconds);
			else
				originalUnits = String.valueOf(seconds);
		} else
			originalUnits = String.valueOf(value);
		return originalUnits;
	}


	/**
	 * Converts date in dd.MM.yyyy format to date in yyyy-MM-dd format.
	 *
	 * @param originalDate date in dd.MM.yyyy format
	 * @return date in yyyy-MM-dd format
	 */
	public static String convertToDashSeparatedYearMonthDayFormat(String originalDate) {

		StringBuilder newDate = new StringBuilder();
		String[] date = originalDate.split("[.]");

		for (int i = 0; i < date.length; i++) {

			if (Integer.parseInt(date[i]) < 10) {
				date[i] = "0" + date[i].replaceAll("^[0]", "");
			}
		}

		String day = date[0];
		String month = date[1];
		String year = date[2];
		String sep = "-";

		newDate.append(year).append(sep).append(month).append(sep).append(day);

		return newDate.toString();
	}


	/**
	 * Converts date in yyyy-MM-dd format to date in dd.MM.yyyy format.
	 *
	 * @param originalDate date in yyyy-MM-dd format
	 * @return date in dd.MM.yyyy format
	 */
	public static String convertToDotSeparetedDayMonthYearFormat(String originalDate) {

		StringBuilder newDate = new StringBuilder();
		String[] date = originalDate.split("[-]");

		for (int i = 0; i < date.length; i++) {

			if (Integer.parseInt(date[i]) < 10) {
				date[i] = "0" + date[i].replaceAll("^[0]", "");
			}
		}

		String day = date[2];
		String month = date[1];
		String year = date[0];
		String sep = ".";

		newDate.append(day).append(sep).append(month).append(sep).append(year);

		return newDate.toString();
	}
}