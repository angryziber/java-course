package net.azib.java.students.t010691.homework;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Decathlon
 *
 * @author Ilja Lutov
 */
public class Decathlon {

	/**
	 * Main method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		int parameter = 0;		// Current command-line argument
		InputData inputData;	// Abstract input data source
		OutputData outputData;	// Abstract output data resource

		try {
			// Create input data source
			InputIdentifier inputIdentifier = InputIdentifier.valueOf(args[parameter++].replaceFirst("^-", "").toUpperCase());
			switch (inputIdentifier) {
				case KBD:
					inputData = new InputDataKbd();
					break;
				case CSV:
					inputData = new InputDataCsv(new File("").getAbsolutePath() + "\\" + args[parameter++]);
					break;
				case DB:
					inputData = new InputDataDb();
					break;
				default:
					System.out.println("Error: invalid input data identifier argument");
					printCommandLineUsageInstructions();
					return;
			}
			
			// Create output data resource
			OutputIdentifier outputIdentifier = OutputIdentifier.valueOf(args[parameter++].replaceFirst("^-", "").toUpperCase());
			switch (outputIdentifier) {
				case SCR:
					outputData = new OutputDataScr();
					break;
				case CSV:
					outputData = new OutputDataCsv(new File("").getAbsolutePath() + "\\" + args[parameter++]);
					break;
				case XML:
					outputData = new OutputDataXml(new File("").getAbsolutePath() + "\\" + args[parameter++]);
					break;
				case HTML:
					outputData = new OutputDataHtml(new File("").getAbsolutePath() + "\\" + args[parameter++]);
					break;
				default:
					System.out.println("Error: invalid output data identifier argument");
					printCommandLineUsageInstructions();
					return;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: missing arguments");
			printCommandLineUsageInstructions();
			return;
		}

		// Container for storing competitors
		List<Competitor> competitors = new LinkedList<Competitor>();

		// Read competitors data and store it in container
		Competitor competitor = inputData.nextResult();
		while (competitor != null) {
			competitors.add(competitor);
			competitor = inputData.nextResult();
		}
		inputData.close();
		
		// Sort all competitors according to their final score
		Collections.sort(competitors);
		
		// Output competitors
		for (Competitor athlete : competitors) {
			// Place is derived from athlete's position in a sorted list.
			// Athletes with the same score are considered to be equal and have the same index.
			// The number of shared places for a given score is equal to the frequency of corresponding athletes.
			outputData.write(athlete, (competitors.indexOf(athlete) + 1) + (Collections.frequency(competitors, athlete) > 1 ? "-" + (competitors.indexOf(athlete) + Collections.frequency(competitors, athlete)) : ""));
		}
		outputData.close();
	}
	
	/**
	 * printCommandLineUsageInstructions
	 * 
	 * Prints instructions on how to use command-line arguments
	 */
	private static void printCommandLineUsageInstructions() {
		System.out.println("\nThe following command-line arguments are accepted:\n");
		System.out.println("Data input");
		System.out.println("   -kbd                 manual data input using keyboard");
		System.out.println("   -csv [file name]     data is taken from CSV file");
		System.out.println("   -db                  data is taken from database\n");
		System.out.println("Data output");
		System.out.println("   -scr                 screen output");
		System.out.println("   -csv [file name]     results are written to CSV file");
		System.out.println("   -xml [file name]     results are written to XML file");
		System.out.println("   -html [file name]    results are written to HTML file\n");
		System.out.println("File paths are relative to current project root.");
		System.out.println("Manual data input suggests the same format as in CSV file,");
		System.out.println("but space separator is used instead.");
	}
}
