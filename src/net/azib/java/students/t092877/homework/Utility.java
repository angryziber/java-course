package net.azib.java.students.t092877.homework;

import java.util.ArrayList;
import java.util.List;

public class Utility {

	static List<Athlete> athletes = new ArrayList<Athlete>();

	public static double convertToProperUnits(String userInput, String type) {

		double properUnits = 0;

		String[] originalUnits = userInput.split(":");

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
