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
import java.util.Collections;
import java.util.List;

/**
 * DecathlonPointsCalculator
 * 
 * @author t030633
 */
public class DecathlonCalculator {

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

	public static String inputProperty;
	public static String outputProperty;

	private Input input;
	private Output output;
	private PrintStream out; // For printing messages to user

	public DecathlonCalculator() {
		this(System.out); // PrintStream to user defaults to System.out
	}

	DecathlonCalculator(PrintStream out) {
		this.out = out;
	}

	public void main(String[] args) {
		DecathlonCalculator calc = new DecathlonCalculator();
		if (calc.init(args)) {
			try {
				List<Athlete> athletes = input.read(new DecathlonAthleteBuilder(new DecathlonChecker(), new AddingCalculator()));
				Collections.sort(athletes);
				output.write(athletes);
				out.println("Done.");
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
	boolean init(String[] args) {
		if ((args.length > 4) || (args.length < 2)) {
			return false; // Filter out wrong number of arguments.
		}
		else {
			InputMethod inputMethod = null;
			OutputMethod outputMethod = null;

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
						inputProperty = string;
					else
						outputProperty = string;
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
				output = outputMethod.getOutput();
				return true;
			}
		}
	}
}
