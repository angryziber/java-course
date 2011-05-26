package net.azib.java.students.t092855.homework;

/**
 * DecathlonCalculator
 * The main module of the program
 * @author t092855
 */
public class DecathlonCalculator {

	/**
	 * The program starts to run from this method.
	 *
	 * @param args input method with parameters: <br>
	 *                                          -console <br>
	 *                                          -csv [filename or path] <br>
	 *                                          -db [competition ID or name] <br>
	 *             output method with parameters: <br>
	 *                                           -console <br>
	 *                                           -csv [filename or path] <br>
	 *                                           -xml [filename or path] <br>
	 *                                           -html [filename or path] <br>
	 */
	public static void main(String[] args) {
		new DecathlonCalculator().parseCommandLineArgumentsAndProcessData(args);
	}

	private void parseCommandLineArgumentsAndProcessData(String[] args) {
		int argumentIndex = 0;

		InputMode inputMode = InputMode.INPUT_MODE_NONE;
		OutputMode outputMode = OutputMode.OUTPUT_MODE_NONE;
		try {
			inputMode = inputMode.parseInputMode(args[argumentIndex++]);

			if (inputMode == InputMode.INPUT_MODE_CSV || inputMode == InputMode.INPUT_MODE_DB) {
				if (!inputMode.parseAndSetInputParameter(args[argumentIndex++])) {
					System.out.println(Error.ERROR_INPUT_PARAMETERS_INCORRECT.getErrorText());
					printUsageText();
					return;
				}
			}

			outputMode = outputMode.parseOutputMode(args[argumentIndex++]);
			if (outputMode == OutputMode.OUTPUT_MODE_CSV ||
					outputMode == OutputMode.OUTPUT_MODE_XML ||
					outputMode == OutputMode.OUTPUT_MODE_HTML) {
				if (!outputMode.parseAndSetOutputParameter(args[argumentIndex])) {
					System.out.println(Error.ERROR_OUTPUT_PARAMETERS_INCORRECT.getErrorText());
					printUsageText();
					return;
				}
			}
		}
		catch (Exception e) {
			System.out.println(Error.ERROR_IO_PARAMETERS_INCORRECT.getErrorText());
			printUsageText();
			return;
		}

		InputStrategy inputStrategy;
		OutputStrategy outputStrategy;
		Competition competition;

		inputStrategy = chooseInputStrategy(inputMode);
		outputStrategy = chooseOutputStrategy(outputMode);
		if (inputStrategy == null || outputStrategy == null)
			return;

		competition = inputStrategy.getData(inputMode.getInputParameter());
		outputStrategy.writeOutput(competition, outputMode.getOutputParameter());

		System.out.println("Data processing completed.");
	}

	private InputStrategy chooseInputStrategy(InputMode inputMode) {
		switch (inputMode) {
			case INPUT_MODE_CONSOLE:
				return new InputConsole();
			case INPUT_MODE_CSV:
				return new InputCSV();
			case INPUT_MODE_DB:
				return new InputDB();
			case INPUT_MODE_NONE:
			default:
				System.out.println(Error.ERROR_INPUT_PARAMETERS_INCORRECT.getErrorText());
				printUsageText();
				return null;
		}
	}

	private OutputStrategy chooseOutputStrategy(OutputMode outputMode) {
		switch (outputMode) {
			case OUTPUT_MODE_CONSOLE:
				return new OutputConsole();
			case OUTPUT_MODE_CSV:
				return new OutputCSV();
			case OUTPUT_MODE_XML:
				return new OutputXML();
			case OUTPUT_MODE_HTML:
				return new OutputHTML();
			case OUTPUT_MODE_NONE:
			default:
				System.out.println(Error.ERROR_OUTPUT_PARAMETERS_INCORRECT.getErrorText());
				printUsageText();
				return null;
		}
	}

	private void printUsageText() {
		System.out.println("Usage:");
		System.out.println("DecathlonCalculator -<input-method> [input-parameters]" +
		" -<output-method> [output-parameters]");
		System.out.println("Where:");
		System.out.println("-<input-method>:");
		System.out.println("-console");
		System.out.println("-csv");
		System.out.println("-db");
		System.out.println("[input-parameters]:");
		System.out.println("file name or path for -csv or competition ID or competition name for -db");
	   	System.out.println("-<output-method>:");
		System.out.println("-console");
		System.out.println("-csv");
		System.out.println("-xml");
		System.out.println("-html");
		System.out.println("[output-parameters]:");
		System.out.println("file name or path");
		System.out.println("Examples:");
		System.out.println("DecathlonCalculator -console -xml results.xml");
		System.out.println("DecathlonCalculator -db 2 -html /tmp/results.html");
		System.out.println("DecathlonCalculator -csv my_input.csv -console");
	}
}
