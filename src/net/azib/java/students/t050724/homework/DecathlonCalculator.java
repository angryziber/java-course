package net.azib.java.students.t050724.homework;

import java.util.ArrayList;

/**
 * DecathlonCalculator
 * 
 * @author xom
 */
public class DecathlonCalculator {

	/**
	 * The main method of the Decathlon point calculator program.
	 * 
	 * @param args
	 *            Input and output methods and parameters.
	 */
	public static void main(String[] args) {

		if (args.length > 1) {

			String outMethod = "";
			String outParameter = "";

			ArrayList<Athlete> athletes = new ArrayList<Athlete>();

			if (args[0].equals("-console") && args.length > 1) {

				if (matchOutput(args[1])) {

					System.out.println("Getting data from console!");

					outMethod = args[1];

					if (args.length > 2) {
						outParameter = args[2];
					}

					ConsoleReader consolereader = new ConsoleReader();
					athletes = consolereader.getDataFromConsole();

					outputData(outMethod, outParameter, athletes);
				}
				else {
					System.out.println("Insert correct output method!");
				}
			}
			else if (args[0].equals("-csv") && args.length > 2) {

				if (matchOutput(args[2])) {

					System.out.println("Getting data from csv file!");

					outMethod = args[2];

					if (args.length > 3) {
						outParameter = args[3];
					}

					CSVReader csvreader = new CSVReader();
					athletes = csvreader.getDataFromCSV(args[1]);

					outputData(outMethod, outParameter, athletes);
				}
				else {
					System.out.println("Insert correct output method!");
				}
			}
			else if (args[0].equals("-db") && args.length > 2) {

				if (matchOutput(args[2])) {

					System.out.println("Getting data from database!");

					outMethod = args[2];

					if (args.length > 3) {
						outParameter = args[3];
					}

					DBReader dbreader = new DBReader();
					athletes = dbreader.getDataFromDB(args[1]);

					outputData(outMethod, outParameter, athletes);
				}
				else {
					System.out.println("Insert correct output method!");
				}
			}
			else {
				System.out.println("Insert correct parameters!");
			}
		}
		else {
			System.out.println("Insert input/output methods!");
		}

	}

	/**
	 * Checks if argument for output is correct.
	 * 
	 * @param string Argument to be checked
	 * @return true if argument is correct output method, false otherwise.
	 */
	private static boolean matchOutput(String outputArg) {

		String[] outputs = { "-console", "-csv", "-xml", "-html" };

		for (String output : outputs) {
			if (output.equals(outputArg)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Calculates score for athletes list and sends the result to output
	 * according to parameters.
	 * 
	 * @param outMethod
	 *            Output method from args.
	 * @param outParameter
	 *            Output parameter from args.
	 * @param athletes
	 *            ArrayList of athletes with input data.
	 */
	private static void outputData(String outMethod, String outParameter, ArrayList<Athlete> athletes) {

		ScoreCalculator scorecalculator = new ScoreCalculator();

		athletes = scorecalculator.calculateScore(athletes);

		if (outMethod.equals("-console")) {

			System.out.println("Writing results to console!");

			ConsoleWriter consolewriter = new ConsoleWriter();
			consolewriter.printDataToConsole(athletes);
		}
		else if (outMethod.equals("-csv")) {

			System.out.println("Writing results to a csv file!");

			CSVWriter csvwriter = new CSVWriter();
			csvwriter.printDataToFile(athletes, outParameter);
		}
		else if (outMethod.equals("-xml")) {

			System.out.println("Writing results to an xml file!");

			XMLWriter xmlwriter = new XMLWriter();
			xmlwriter.createXML(athletes, outParameter);
		}
		else if (outMethod.equals("-html")) {

			System.out.println("Writing results to html file!");

			HTMLWriter htmlwriter = new HTMLWriter();
			htmlwriter.createHTML(athletes, outParameter);
		}
		else {
			System.out.println("Output mehtod not recognized!");
		}
		System.out.println("All done...");
	}
}
