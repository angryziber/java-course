package net.azib.java.students.t030633.homework;

import net.azib.java.students.t030633.homework.model.AddingCalculator;
import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.DecathlonAthleteBuilder;
import net.azib.java.students.t030633.homework.model.DecathlonChecker;
import net.azib.java.students.t030633.homework.view.in.Input;
import net.azib.java.students.t030633.homework.view.in.InputMethod;
import net.azib.java.students.t030633.homework.view.out.Output;
import net.azib.java.students.t030633.homework.view.out.OutputMethod;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;

/**
 * Homework in Java course IAG0040 "Programmeerimise erikursus II"
 * @version 1.0
 * @author Tarmo Ojala, 030633 IASM
 */
public class DecathlonCalculator {

	/** root path for all files */
	private static final URL PATH = DecathlonCalculator.class.getResource(".");

	static final String HELP_MSG;
	static final String LN = System.getProperty("line.separator");
	static {
		StringBuilder sb = new StringBuilder();
		sb.append("Decathlon points calculator by 030633").append(LN).append("usage: ").append(
				DecathlonCalculator.class.getSimpleName()).append(" -input [options] -output [options]").append(LN);
		sb.append(" possible inputs: ");
		for (InputMethod im : InputMethod.values()) {
			sb.append(im.name().toLowerCase()).append(" ");
		}
		sb.append(LN).append(" possible outputs: ");
		for (OutputMethod om : OutputMethod.values()) {
			sb.append(om.name().toLowerCase()).append(" ");
		}
		HELP_MSG = sb.toString();
	}

	private static Input input;
	private static Output output;
	private static PrintStream out = System.out; // For printing messages to user

	static void setPrintStream(PrintStream set) {
		DecathlonCalculator.out = set;
	}

	public static void main(String[] args) {
		if (init(args)) {
			try {
				List<Athlete> athletes = input.read(new DecathlonAthleteBuilder(new DecathlonChecker(), new AddingCalculator()));
				Collections.sort(athletes);
				output.write(athletes);
			}
			catch (IOException ioe) {
				/*
				 * Catch all exceptions from inputs and outputs. Message should
				 * be something informative.
				 */
				out.print("Calculation failed. ");
				out.println(ioe.getMessage());
			}
			catch (Exception e) {
				out.println("Unexpected program crash, please contact author.");
			}
		}
		else
			// Incorrect arguments, user needs help.
			out.println(HELP_MSG);
	}

	/**
	 * Initializes calculator.
	 * 
	 * @param args -
	 *            arguments to the program
	 * @return true if arguments are formatically correct
	 */
	static boolean init(String[] args) {
		if ((args.length > 4) || (args.length < 2)) {
			return false; // Filter out wrong number of arguments.
		}
		else {
			InputMethod inputMethod = null;
			OutputMethod outputMethod = null;
			String inputParameter = null;
			String outputParameter = null;

			for (String string : args) {
				if (string.startsWith("-")) {
					if (inputMethod == null) {
						try {
							inputMethod = InputMethod.valueOf(string.substring(1).toUpperCase());
						}
						catch (IllegalArgumentException e) {
							// Specified input method does not exist.
							return false;
						}
					}
					else {
						try {
							outputMethod = OutputMethod.valueOf(string.substring(1).toUpperCase());
						}
						catch (IllegalArgumentException e) {
							// Specified output method does not exist.
							return false;
						}
					}
				}
				else {
					if (outputMethod == null)
						inputParameter = string;
					else
						outputParameter = string;
				}
			}
			/*
			 * Only check if both methods exist because some methods don't
			 * require parameters. Parameter checking is therefore done in
			 * methods themselves.
			 */
			if ((inputMethod == null) || (outputMethod == null))
				return false;
			else {
				input = inputMethod.getInput();
				input.setParameters(new String[] { PATH.getPath(), inputParameter });
				output = outputMethod.getOutput();
				output.setParameters(new String[] { PATH.getPath(), outputParameter });
				return true;
			}
		}
	}
	
}
