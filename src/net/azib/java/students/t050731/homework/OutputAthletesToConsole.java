package net.azib.java.students.t050731.homework;

import java.util.ArrayList;

/**
 * OutputAthleteToConsole
 * 
 * This class handles the output to console
 * 
 * @author Raigo
 */
public class OutputAthletesToConsole {
	private HelperMethods helper = new HelperMethods();

	/**
	 * This method outputs athletes to console
	 * 
	 * @param athletes
	 *            arraylist containing athlete objects
	 */
	protected void createConsoleOutput(ArrayList<Athlete> athletes) {

		System.out.println("Displaying " + athletes.size() + " athlete(s) in console output.");
		for (String athlete : helper.createAthleteStrings(athletes)) {
			System.out.println(athlete);
		}
	}
}
