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
	 * @param args todo
	 */
	public static void main(String[] args) {
		new DecathlonCalculator().parseCommandLineArguments(args);
	}

	private void parseCommandLineArguments(String[] args) {
		int argumentIndex = 0;

		InputMode inputMode = InputMode.INPUT_MODE_NONE;
		OutputMode outputMode = OutputMode.OUTPUT_MODE_NONE;
		try {
			inputMode = inputMode.parseInputMode(args[argumentIndex++]);

			if (inputMode == InputMode.INPUT_MODE_CSV || inputMode == InputMode.INPUT_MODE_DB) {
				if (!inputMode.parseAndSetInputParameter(args[argumentIndex++])) {
					System.out.println(Error.ERROR_INPUT_PARAMETERS_INCORRECT.getErrorText());
					return;
				}
			}

			outputMode = outputMode.parseOutputMode(args[argumentIndex++]);
			if (outputMode == OutputMode.OUTPUT_MODE_CSV ||
					outputMode == OutputMode.OUTPUT_MODE_XML ||
					outputMode == OutputMode.OUTPUT_MODE_HTML) {
				if (!outputMode.parseAndSetOutputParameter(args[argumentIndex])) {
					System.out.println(Error.ERROR_OUTPUT_PARAMETERS_INCORRECT.getErrorText());
					return;
				}
			}
		}
		catch (Exception e) {
			System.out.println(Error.ERROR_IO_PARAMETERS_INCORRECT.getErrorText());
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
				return null;
		}
	}
}
