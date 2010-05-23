package net.azib.java.students.t050731.homework;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * DecathlonCalculator
 * 
 * Main class, handles input and output from various sources
 * 
 * @author Raigo
 */
public class DecathlonCalculator {
	static HelperMethods helper = new HelperMethods();
	static String[] outMethodValues = { "-console", "-csv", "-xml", "-html" };
	static String outputMethod = "";
	static String outputParameter = "";
	static ArrayList<Athlete> athletes;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Entry point, compares input method and initiates required classes
		 * 
		 * @param args
		 *            program arguments
		 */
		if (args.length == 0) {
			printSyntax();
		}
		else if (args[0].equalsIgnoreCase("-console") && args.length > 1) {
			outputMethod = args[1];
			if (checkOutParameter() == true) { // if false, exit before init
				setOutParameter(args, 2);
				System.out.println("Entering athlete(s) from console input.");
				InputAthletesFromConsole inputFromConsole = new InputAthletesFromConsole();
				athletes = inputFromConsole.readFromConsole();
			}
		}
		else if (args[0].equalsIgnoreCase("-csv") && args.length > 2) {
			outputMethod = args[2];
			if (checkOutParameter() == true) { // if false, exit before init
				setOutParameter(args, 3);
				System.out.println("Entering athlete(s) from csv input:");
				InputAthletesFromCSV inputFromCSV = new InputAthletesFromCSV();
				athletes = inputFromCSV.readFromCSV(helper.getFullPath(args[1]));
				System.out.println(helper.getFullPath(args[1]));
			}
		}
		else if (args[0].equalsIgnoreCase("-db") && args.length > 2) {
			System.out.println("Entering athlete(s) from db input:");
			InputAthletesFromDatabase inputFromDB = new InputAthletesFromDatabase();
			athletes = inputFromDB.getAthletesFromDatabase(args[1]);
			outputMethod = args[2];
			setOutParameter(args, 3);
		}
		else {
			printSyntax();
		}
		System.out.println("");
		if (athletes != null)
			outputData();
	}

	/**
	 * Outputs data to console, csv, xml or html depending on output method and
	 * parameters
	 */
	private static void outputData() {
		if (outputMethod.equalsIgnoreCase("-console")) {
			OutputAthletesToConsole outputToConsole = new OutputAthletesToConsole();
			outputToConsole.createConsoleOutput(athletes);
		}
		else if (outputMethod.equalsIgnoreCase("-csv")) {
			OutputAthletesToCSV outputToCSV = new OutputAthletesToCSV();
			System.out.println(outputToCSV.createCSVOutput(athletes, outputParameter));
		}
		else if (outputMethod.equalsIgnoreCase("-xml")) {
			OutputAthletesToXML outputToXML = new OutputAthletesToXML();
			System.out.println(outputToXML.createXMLOutput(athletes, outputParameter));
		}
		else if (outputMethod.equalsIgnoreCase("-html")) {
			OutputAthletesToHTML outputToHML = new OutputAthletesToHTML();
			System.out.println(outputToHML.createHTMLOutput(athletes, outputParameter));
		}
		System.out.println("\nProgram completed successfully.");
	}

	private static boolean checkOutParameter() {
		if (Arrays.asList(outMethodValues).contains(outputMethod))
			return true;
		else {
			printSyntax();
			return false;
		}
	}

	private static void setOutParameter(String[] args, int index) {
		if (args.length > index) {
			outputParameter = helper.getFullPath(args[index]);
		}
	}

	private static void printSyntax() {
		System.out
				.println("Incorrect syntax detected. Valid syntax: <program> -<input-method> [input-parameters] -<output-method> [output-parameters]");
	}

}
