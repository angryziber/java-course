package net.azib.java.students.t092877.homework;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Utils{
	
	public static void sortAthletes(List<Athlete> athletes) {
		
		Collections.sort(athletes);
		HashMap<String, int[]> placeRanges = new HashMap<String, int[]>();
		
		int place = 1;
		int[] range;
		
		// set place intervals for corresponding athlete

		for (Athlete athlete : athletes) {
			range = placeRanges.get(Integer.toString(athlete.getTotalScore()));

			if(range == null){
				placeRanges.put(Integer.toString(athlete.getTotalScore()), new int[]{ place, place });
			}

			else {
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

			if(range[0] == range[1]) {
				athlete.setPlace(Integer.toString(range[0]));
			}

			else {
				athlete.setPlace(range[0] + "-" + range[1]);
			}
		}
	}


	public static double convertToProperUnits(String input, String type) {

		double properUnits = 0;
		String[] originalUnits = input.split(":");

		if (type.equals("jumping"))
			properUnits = Double.parseDouble(originalUnits[0]) * 100;

		else if (type.equals("running")) {
			if (originalUnits.length == 2)
				properUnits = Double.parseDouble(originalUnits[0]) * 60 + Double.parseDouble(originalUnits[1]);

			else
				properUnits = Double.parseDouble(originalUnits[0]);
		}
		else
			properUnits = Double.parseDouble(originalUnits[0]);
		return properUnits;
	}

	public static String convertToOriginalUnits(double value, String type) {
		String originalUnits = "";

		if (type.equals("jumping"))
			originalUnits = String.valueOf(value / 100.0);

		else if (type.equals("running")) {
			int minutes = (int) (value / 60);
			double seconds = Math.round(value % 60 * 100) / 100.0;

			if (value >= 60)
				originalUnits = String.valueOf(minutes) + ":" + String.valueOf(seconds);
			else
				originalUnits = String.valueOf(seconds);
		}
		else
			originalUnits = String.valueOf(value);
		return originalUnits;	
	}
}
