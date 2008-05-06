package net.azib.java.students.t030633.homework;

import net.azib.java.students.t030633.homework.model.AddingCalculator;
import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.DecathlonAthleteBuilder;
import net.azib.java.students.t030633.homework.model.DecathlonChecker;
import net.azib.java.students.t030633.homework.view.Connections;
import net.azib.java.students.t030633.homework.view.Files;
import net.azib.java.students.t030633.homework.view.Input;
import net.azib.java.students.t030633.homework.view.InputMethod;
import net.azib.java.students.t030633.homework.view.Output;
import net.azib.java.students.t030633.homework.view.OutputMethod;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

/**
 * DecathlonPointsCalculator
 * 
 * @author t030633
 */
public class DecathlonPointsCalculator {

	private static final String CALCULATION_ERROR = "Calculation error:";

	private static final String HELP_MSG;

	private static final String LN = System.getProperty("line.separator");

	static {
		StringBuilder sb = new StringBuilder();
		sb.append("Decathlon points calculator by 030633").append(LN).append("usage: ").append(
				DecathlonPointsCalculator.class.getSimpleName()).append(" -input [options] -output [options]").append(LN);
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

	public static void main(String[] args) {
		try {
			new DecathlonPointsCalculator().run(args);
		}
		catch (Exception e) {
			System.out.println(HELP_MSG);
		}
	}

	/**
	 * Parses command line arguments and configures Files and Connections if
	 * needed. Calls calculate if successful.
	 * 
	 * @param args
	 */
	private void run(String[] args) {

		InputMethod im = null;
		OutputMethod om = null;
		boolean isOpt = false;

		/*
		 * The following tries to parse arguments and options.
		 */
		try {

			for (String string : args) {
				if (string.startsWith("-")) {
					if (im == null) {
						im = InputMethod.valueOf(string.substring(1).toUpperCase());
						isOpt = true;
					}
					else {
						om = OutputMethod.valueOf(string.substring(1).toUpperCase());
						isOpt = true;
					}
				}
				else if (isOpt) {
					if (om == null) {
						switch (im) {
						case CONSOLE:
							break;
						case CSV:
							Files.setInput(string);
							break;
						case DATABASE:
							Connections.PARAMETER = string;
							break;
						}
						isOpt = false;
					}
					else {
						switch (om) {
						case CONSOLE:
							break;
						default:
							Files.setOutput(string);
							break;
						}
						isOpt = false;
					}
				}
			}

			calculate(im.getInput(), om.getOutput());

		}
		catch (URISyntaxException e) {
			System.out.println(HELP_MSG);
		}

	}

	/**
	 * Reads athletes from input, writes them to output.
	 * 
	 * @param input
	 * @param output
	 */
	private void calculate(Input input, Output output) {

		try {
			List<Athlete> athletes;
			athletes = input.builder(new DecathlonAthleteBuilder(new DecathlonChecker(), new AddingCalculator())).read();
			Collections.sort(athletes);
			output.write(athletes);
		}
		catch (IOException e) {
			System.out.println(CALCULATION_ERROR);
			System.out.println(e.getMessage());
		}
		finally {
			try {
				input.close();
				output.close();
			}
			catch (IOException e) { // close quietly
			}
		}

	}

}
