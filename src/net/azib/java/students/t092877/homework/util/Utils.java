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
 * @version 1.1 20.05.2011
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
		Map<String, int[]> placeRanges = new HashMap<String, int[]>();

		int place = 1;
		int[] range;

		// set places interval for corresponding athlete

		for (Athlete athlete : athletes) {

			range = placeRanges.get(Integer.toString(athlete.getTotalScore()));

			if (range == null){
				placeRanges.put(Integer.toString(athlete.getTotalScore()), new int[]{ place, place });
			} else {
				range[1] = place;
			}
			place++;
		}

		// set place achieved by athlete in the competition

		for (Athlete athlete : athletes) {

			range = placeRanges.get(Integer.toString(athlete.getTotalScore()));

			if(range == null) {
				throw new RuntimeException("No entry in the list...");
			}

			if (range[0] == range[1]) {
				athlete.setPlace(Integer.toString(range[0]));
			} else {
				athlete.setPlace(range[0] + "-" + range[1]);
			}
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

		double properUnits = 0;
		String[] originalUnits = value.split(":");

		// athlete's performance measured in centimeters for jumping events
		if (type.equals("jumping"))	{
			properUnits = Double.parseDouble(originalUnits[0]) * 100;

		// athlete's performance measured in seconds for running events
		} else if (type.equals("running")) {

			if (originalUnits.length == 2)
				properUnits = Double.parseDouble(originalUnits[0]) * 60 + Double.parseDouble(originalUnits[1]);

			else
				properUnits = Double.parseDouble(originalUnits[0]);
		// athlete's performance measured in meters for throwing events
		} else
			properUnits = Double.parseDouble(originalUnits[0]);
		return properUnits;
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