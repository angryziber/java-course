package net.azib.java.students.t092855.homework;

/**
 * OutputMode
 *  Enumeration for output mode.
 * @author t092855
 */
public enum OutputMode {
	OUTPUT_MODE_CONSOLE,
	OUTPUT_MODE_CSV,
	OUTPUT_MODE_XML,
	OUTPUT_MODE_HTML,
	OUTPUT_MODE_NONE;

	private String outArg;

	/**
	 * Parses output argument and returns OutputMode
	 * @param arg output argument to parse.
	 * @return output mode
	 */
	public OutputMode parseOutputMode(String arg) {
		if (arg.equals("-console")) {
			return OUTPUT_MODE_CONSOLE;
		}
		if (arg.equals("-csv")) {
			return OUTPUT_MODE_CSV;
		}
		if (arg.equals("-xml")) {
			return OUTPUT_MODE_XML;
		}
		if (arg.equals("-html")) {
			return OUTPUT_MODE_HTML;
		}
		return OUTPUT_MODE_NONE;
	}

	/**
	 * Get output parameter.
	 * @return output parameter. E.g. file name or path.
	 */
	public String getOutputParameter() {
		return outArg;
	}

	/**
	 * Parses output parameter and stores it.
	 * @param outArg string to parse. Must not start with "-".
	 * @return true if it is a valid parameter, else false.
	 */
	public boolean parseAndSetOutputParameter(String outArg) {
		if (outArg.startsWith("-"))
			return false;
		this.outArg = outArg;
		return true;
	}
}
