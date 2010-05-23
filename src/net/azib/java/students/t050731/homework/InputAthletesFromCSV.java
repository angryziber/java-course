package net.azib.java.students.t050731.homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * InputAthletesFromCsvFile
 * 
 * This class handles the input from csv file
 * 
 * @author Raigo
 */
public class InputAthletesFromCSV {

	private HelperMethods helper = new HelperMethods();
	private ArrayList<Athlete> athleteList = new ArrayList<Athlete>();

	/**
	 * This method converts reads athlete information from csv file
	 * 
	 * @param fileName
	 *            contains input file path
	 */
	protected ArrayList<Athlete> readFromCSV(String fileName) {
		if (helper.checkIfFileExits(fileName) == false) {
			System.out.println("Input file does not exist:");
			return null;
		}

		try {
			String lineFromFile = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF8"));
			int i = 0;

			while ((lineFromFile = br.readLine()) != null) {
				AddAthleteToArrayList(lineFromFile);
				i++;
			}
		}
		catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return athleteList;
	}

	private void AddAthleteToArrayList(String line) {
		String parameters[] = new String[13];
		try {
			parameters = line.split(",");
			athleteList.add(helper.verifyAndCreateAthlete(parameters[0], parameters[1], parameters[2], parameters[3],
					parameters[4], parameters[5], parameters[6], parameters[7], parameters[8], parameters[9], parameters[10],
					parameters[11], parameters[12]));
		}
		catch (Exception e) {
			System.out.println("Input line from csv file is not correctly formatted. Skipping line.");
		}

	}
}