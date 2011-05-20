package net.azib.java.students.t092877.homework;

import net.azib.java.students.t092877.homework.io.*;
import net.azib.java.students.t092877.homework.model.Competition;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * DecathlonCalc.java
 * Purpose: provides commandline input processing and validation
 *
 * @author Artjom Kruglenkov / 092877
 * @version 1.0 20.05.2011
 */
public class DecathlonCalc {

	// pattern for commandline input validation
	public static final String VALIDATION_PATTERN = "(^(-console\\s+)((-console)\\s*$|(-csv\\s+[\\w/\\\\:]+.csv)\\s*$|(-xml\\s+[\\w/\\\\:]+.xml)\\s*$|(-html\\s+[\\w/\\\\:]+.(html|htm))\\s*$))|" +
													"(^(-csv\\s+)([\\w/\\\\:]+.csv\\s+)((-console)\\s*$|(-csv\\s+[\\w/\\\\:]+.csv)\\s*$|(-xml\\s+[\\w/\\\\:]+.xml)\\s*$|(-html\\s+[\\w/\\\\:]+.(html|htm))\\s*$))|" +
													"(^(-db\\s+)(([1-9][0-9]+|\\w+)\\s+)((-console)\\s*$|(-csv\\s+[\\w/\\\\:]+.csv)\\s*$|(-xml\\s+[\\w/\\\\:]+.xml)\\s*$|(-html\\s+[\\w/\\\\:]+.(html|htm))\\s*$))";

	// patterns to determine an input mode
	private static final Pattern READ_FROM_CONSOLE = Pattern.compile("^(-console\\s+)");
	private static final Pattern READ_FROM_CSV_FILE = Pattern.compile("^(-csv\\s+)([\\w/\\\\:]+.csv\\s+)");
	private static final Pattern READ_FROM_DATABASE = Pattern.compile("^(-db\\s+)(([1-9][0-9]+|\\w+)\\s+)");

	// patterns to determine an output mode
	private static final Pattern WRITE_TO_CONSOLE = Pattern.compile("(-console)\\s*$");
	private static final Pattern WRITE_TO_CSV_FILE = Pattern.compile("(-csv\\s+[\\w/\\\\:]+.csv)\\s*$");
	private static final Pattern WRITE_TO_XML_FILE = Pattern.compile("(-xml\\s+[\\w/\\\\:]+.xml)\\s*$");
	private static final Pattern WRITE_TO_HTML_FILE = Pattern.compile("(-html\\s+[\\w/\\\\:]+.(html|htm))\\s*$");


	/**
	 * The main method of decathlon calculator
	 *
	 * @param args an array of commandline parameters
	 */
	public static void main(String[] args) {

		Competition competition;

		if (validateCommandLineInput(getCommandLineInput(args))) {

			competition = new Competition();
			read(competition, args);
			write(competition, args);

		} else if (args.length == 0) {

			System.err.println("\n>>> ERROR: the commandline parameter list is emply.");

		} else {

			System.err.println("\n>>> ERROR: the commandline input is incorrectly specified.");
			System.err.println(">>> Provided commandline parameters: " + getCommandLineInput(args));
		}

		System.out.println("\nThank you, come again!");
	}

	/**
	 * Sets an input processing mode based on the commandline parameters
	 *
	 * @param competition an instance of decathlon competition
	 * @param args an array of commandline parameters
	 */
	private static void read(Competition competition, String[] args) {

		String mode = "read";
		String commandLineInput = getCommandLineInput(args);

		if (READ_FROM_CONSOLE.matcher(commandLineInput).find()) {

			setContext(new StandardInputStrategy(), competition);

		} else if (READ_FROM_CSV_FILE.matcher(commandLineInput).find()) {

			setContext(new CsvFileInputStrategy(new File(getParameterValue(args, mode))), competition);

		} else if (READ_FROM_DATABASE.matcher(commandLineInput).find()) {

			setContext(new DatabaseInputStrategy(getParameterValue(args, mode)), competition);
		}
	}

	/**
	 * Sets an output processing mode based on the commandline parameters
	 *
	 * @param competition an instance of decathlon competition
	 * @param args an array of commandline parameters
	 */
	private static void write(Competition competition, String[] args) {

		String mode = "write";
		boolean htmlTransform = false;
		String commandLineInput = getCommandLineInput(args);

		if (WRITE_TO_CONSOLE.matcher(commandLineInput).find()) {

			setContext(new StandardOutputStrategy(), competition);

		} else if (WRITE_TO_CSV_FILE.matcher(commandLineInput).find()) {

			setContext(new CsvFileOutputStrategy(new File(getParameterValue(args, mode))), competition);

		} else if (WRITE_TO_XML_FILE.matcher(commandLineInput).find()) {

			htmlTransform = false;
			setContext(new XmlFileOutputStrategy(new File(getParameterValue(args, mode)), htmlTransform), competition);

		} else if (WRITE_TO_HTML_FILE.matcher(commandLineInput).find()) {

			htmlTransform = true;
			setContext(new XmlFileOutputStrategy(new File(getParameterValue(args, mode)), htmlTransform), competition);
		}
	}

	/**
	 * Sets context instance to specified strategy instance
	 *
	 * @param strategy an instance of specified strategy implementation
	 * @param competition an instance of decathlon competition
	 */
	private static void setContext(Strategy strategy, Competition competition) {

		Context context;

		context = new Context(strategy);
		context.executeStrategy(competition);
	}

	/**
	 * Returns the parameter value for specified mode
	 *
	 * @param args an array of commandline parameters
	 * @param mode the mode of operation (read/write)
	 * @return the parameter value for specified mode
	 */
	private static String getParameterValue(String[] args, String mode) {

		String parameter = null;

		if (mode.equals("read")) {
			parameter = args[1];

		} else if (mode.equals("write")) {

			if (args.length == 3)
				parameter = args[2];
			else if (args.length == 4)
				parameter = args[3];
		}
		return parameter;
	}

	/**
	 * Returns a single string representation of commandline input
	 *
	 * @param args an array of commandline parameters
	 * @return a single string of commandline input
	 */
	private static String getCommandLineInput(String[] args) {

		StringBuilder command = new StringBuilder();
		String sep = " ";

		for (String str : args)
			command.append(str).append(sep);

		return command.toString();
	}

	/**
	 * Tests whether provided commandline input has a valid format
	 *
	 * @param str commandline input string
	 * @return true if an input string validates against a validation pattern
	 */
	private static boolean validateCommandLineInput(String str) {

		Pattern p = Pattern.compile(VALIDATION_PATTERN);
		Matcher m = p.matcher(str);
		return m.matches();

	}
}
