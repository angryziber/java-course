package net.azib.java.students.t050724.homework;

import java.util.ArrayList;

/**
 * ConsolePrinter
 * 
 * @author xom
 */
public class ConsoleWriter {

	SupportClass supporter = new SupportClass();

	/**
	 * Prints the data of the parameter "athletes" to console.
	 * 
	 * @param athletes
	 *            ArrayList of Athlete that is to be printed out to console.
	 */
	protected void printDataToConsole(ArrayList<Athlete> athletes) {

		ArrayList<String> athletesToPrint = new ArrayList<String>();
		athletesToPrint = supporter.createAthleteStrings(athletes);

		for (String string : athletesToPrint) {
			System.out.println(string);
		}
	}
}
