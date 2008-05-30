package net.azib.java.students.t001370.homework;

/**
 * IOMethod
 * Enum for holding possible IO methods
 * @author maksim
 */
public enum IOMethod {
	NONE,
	CONSOLE_INPUT,
	CONSOLE_OUTPUT,
	CSV_INPUT,
	CSV_OUTPUT,
	DB_INPUT,
	XML_OUTPUT,
	HTML_OUTPUT;
	
	private String ioArgument;
	
	
	/**
	 * Set argument for given IO method.
	 * In case of DB the argument is competition id or name.
	 * In cese of CSV
	 * @param str
	 */
	public void setIOArgument(String str){
		ioArgument = str;
	}
	
	/**
	 * Get IO argument for specified IO method
	 * @return io argument string (ex. filepath, db search condition)
	 */
	public String getIOArgument(){
		return ioArgument;
	}
	
	/**
	 * For parsing input argument method string into IOMethod
	 * @param strToParse - method argument
	 * @return IOMethod
	 */
	public IOMethod parseInputMethod(String strToParse){
		IOMethod method = NONE;

		if (strToParse.equals("-console") == true) {
			method = CONSOLE_INPUT;
		}
		else if (strToParse.equals("-csv") == true){
			method = CSV_INPUT;
		}
		else if (strToParse.equals("-db") == true){
			method = DB_INPUT;
		}
		
		return method;
	}

	/**
	 * For parsing output argument method string into IOMethod
	 * @param strToParse - method argument
	 * @return IOMethod
	 */
	public IOMethod parseOutputMethod(String strToParse){
		IOMethod method = NONE;

		if (strToParse.equals("-console") == true) {
			method = CONSOLE_OUTPUT;
		}
		else if (strToParse.equals("-csv") == true){
			method = CSV_OUTPUT;
		}
		else if (strToParse.equals("-xml") == true){
			method = XML_OUTPUT;
		}
		else if (strToParse.equals("-html") == true){
			method = HTML_OUTPUT;
		}
		
		return method;
	}

}
