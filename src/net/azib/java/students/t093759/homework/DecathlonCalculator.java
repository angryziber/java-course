package net.azib.java.students.t093759.homework;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * Decathlon calculator provides functionality for
 * calculating points of athletes and output them to different sources etc.
 *
 * @author dionis
 *         5/29/117:53 PM
 */
public class DecathlonCalculator {
	public static void main(String[] args) {
		new DecathlonCalculator().handleRequest(args);
	}

	void handleRequest(String[] parameters) {
		if (parameters.length < 2 || parameters.length > 4) {
			printHelpMessage();
			return;
		}
		AthleteLoader athleteLoader;
		int currentIndexOfParam = 0;
		System.out.println("Params:"+ Arrays.asList(parameters));
		final String inputMethod = parameters[currentIndexOfParam++].trim().toLowerCase();
		if (inputMethod.equals("-console")) {
			System.out.println("Console input.");
			athleteLoader = new ConsoleLoader();
			System.out.println(athleteLoader.load(null,11));
		} else if (inputMethod.equals("-csv")) {
			System.out.println("Comma separated output set.");
			System.out.println("source: "+parameters[currentIndexOfParam++]);
		} else if (inputMethod.equals("-db")) {
			System.out.println("Database:");
			System.out.println("source: "+parameters[currentIndexOfParam++]);
		} else {
			System.out.println("Bad input source:"+inputMethod);
		}
		final String outputMethod = parameters[currentIndexOfParam++].trim().toLowerCase();
		if (outputMethod.equals("-console")) {
			System.out.println("Console output.");
		} else if (outputMethod.equals("-csv")) {
			System.out.println("Comma separated output set.");
			System.out.println("output: "+parameters[currentIndexOfParam++]);
		} else if (outputMethod.equals("-xml")) {
			System.out.println("XML:");
			System.out.println("output: "+parameters[currentIndexOfParam++]);
		}else if (outputMethod.equals("-html")) {
			System.out.println("HTML:");
			System.out.println("output: "+parameters[currentIndexOfParam++]);
		}
		else {
			System.out.println("Bad output source");
		}
	}

	private void printHelpMessage() {
		System.out.println("usage: <program> -<input-method> [input-parameters] -<output-method> [output-parameters]");
		System.out.println("where\n" +
				"<program> is your main class, e.g. java net.azib.java.students.txxxxxx.homework.DecathlonCalculator\n" +
				"<input-method> is the name of the input method preceded by dash (-): -console, -csv, -db\n" +
				"[input-parameters] are optional parameters depending on the specified input method:\n" +
				"-console - no parameters\n" +
				"-csv - input file name or path\n" +
				"-db - competition id or name - both should work (DB connection string must be read from db.properties in the same package as the main class)\n" +
				"<output-method> is the name of the output method preceded by dash (-): -conole, -csv, -xml, -html\n" +
				"[output-parameters] are optional parameters depending on the specified output method:\n" +
				"-conole - no parameters\n" +
				"-csv - output file name or path\n" +
				"-xml - output file name or path\n" +
				"-html - output file name or path");
	}
}
