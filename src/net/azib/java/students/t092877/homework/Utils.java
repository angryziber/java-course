package net.azib.java.students.t092877.homework;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Utils {

	static void sortAthletes(List<Athlete> athletes) {

		if (athletes == null)
			return;

		Collections.sort(athletes);
		Map<String, int[]> placeRanges = new HashMap<String, int[]>();

		int place = 1;
		int[] range;

		// set place intervals for corresponding athlete

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


	static double convertToProperUnits(String input, String type) {

		double properUnits = 0;
		String[] originalUnits = input.split(":");

		if (type.equals("jumping"))	{
			properUnits = Double.parseDouble(originalUnits[0]) * 100;

		} else if (type.equals("running")) {

			if (originalUnits.length == 2)
				properUnits = Double.parseDouble(originalUnits[0]) * 60 + Double.parseDouble(originalUnits[1]);

			else
				properUnits = Double.parseDouble(originalUnits[0]);
		} else
			properUnits = Double.parseDouble(originalUnits[0]);
		return properUnits;
	}


	static String convertToOriginalUnits(double value, String type) {

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


	static String convertToDashSeparatedYearMonthDayFormat(String originalDate) {

		StringBuilder newDate = new StringBuilder();
		String[] date = originalDate.split("[-/.]");

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


	static String convertToDotSeparetedDayMonthYearFormat(String originalDate) {

		StringBuilder newDate = new StringBuilder();
		String[] date = originalDate.split("[- /.]");

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

