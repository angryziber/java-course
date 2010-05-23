package net.azib.java.students.t050731.homework;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * OutputAthletesToCsvFile
 * 
 * this class handles the output to csv file
 * 
 * @author Raigo
 */
public class OutputAthletesToCSV {
	private HelperMethods helper = new HelperMethods();

	/**
	 * This method outputs athletes to csv file
	 * 
	 * @param athletes
	 *            carraylist containing athlete objects
	 * @param fileName
	 *            contains output file path
	 */
	protected String createCSVOutput(ArrayList<Athlete> athletes, String fileName) {
		ArrayList<String> athleteStrings;
		athleteStrings = helper.createAthleteStrings(athletes);
		try {
			if (athleteStrings.size() == 0)
				return "";
			
			System.out.println("Displaying " + athletes.size() + " athlete(s) in csv output.");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF8"));
			for (String athlete : athleteStrings) {
				bw.write(athlete);
				bw.newLine();
			}
			bw.close();
		}
		catch (IOException e) {
			System.out.println("File operation failed.");
		}
		return fileName;
	}
}
