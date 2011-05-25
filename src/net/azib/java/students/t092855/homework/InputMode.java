package net.azib.java.students.t092855.homework;

/**
 * InputMode
 * Enumeration for input mode.
 *
 * @author t092855
 */
public enum InputMode {
	INPUT_MODE_CONSOLE,
	INPUT_MODE_CSV,
	INPUT_MODE_DB,
	INPUT_MODE_NONE;

	private String inArg;

	/**
	 * Parses input argument and returns InputMode
	 * @param arg Input argument to parse.
	 * @return input mode
	 */
	public InputMode parseInputMode(String arg) {
		if (arg.equals("-console")) {
			return INPUT_MODE_CONSOLE;
		}
		if (arg.equals("-csv")) {
			return INPUT_MODE_CSV;
		}
		if (arg.equals("-db")) {
			return INPUT_MODE_DB;
		}
		return INPUT_MODE_NONE;
	}

	/**
	 * Get input parameter.
	 * @return input parameter. E.g. file name or path
	 */
	public String getInputParameter() {
		return inArg;
	}

	/**
	 * Parses input parameter and stores it.
	 * @param inArg string to parse. Must not start with "-".
	 * @return true if it is a valid parameter, else false.
	 */
	public boolean parseAndSetInputParameter(String inArg) {
		if (inArg.startsWith("-"))
			return false;
		this.inArg = inArg;
		return true;
	}
}
