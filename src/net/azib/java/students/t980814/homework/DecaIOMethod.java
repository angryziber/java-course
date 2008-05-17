package net.azib.java.students.t980814.homework;

/**
 * A simple class that contains information about input and output methods.
 * This class contains two enums: DecaInputMethod and DecaOutputMethod,
 * methods to set their values and associating String parameters.
 * 
 * @author Allan Berg
 */
public class DecaIOMethod {

	public enum DecaInputMethod {
		UNKNOWN,
		CONSOLE,
		DATABASE,
		CSV;
	}
	
	public enum DecaOutputMethod {
		UNKNOWN,
		CONSOLE,
		CSV,
		XML,
		HTML;
	}
	
	public DecaInputMethod   inputMethod = DecaInputMethod.UNKNOWN;
	public DecaOutputMethod outputMethod = DecaOutputMethod.UNKNOWN;
	public String         inputParameter = null;
	public String        outputParameter = null;

	/**
	 * Sets the input method and its parameter
	 * @param i - input method
	 * @param param - parameter of the input method (e.g. file name of CSV)
	 */
	public void setInputMethod(DecaInputMethod i, String param) {
		inputMethod = i;
		inputParameter = param;
	}
		
	/**
	 * Sets the output method and its parameter
	 * @param o - output method
	 * @param param - parameter of the output method (e.g. file name of CSV)
	 */
	public void setOutputMethod(DecaOutputMethod o, String param) {
		outputMethod = o;
		outputParameter = param;
	}
		
	/**
	 * Verifies if both input and output methods are set
	 * @return boolean - true, if both methods are set
	 */
	public boolean isIOMethodLegal() {
		return ((inputMethod != DecaInputMethod.UNKNOWN) &&
		        (outputMethod != DecaOutputMethod.UNKNOWN));
	}
}
