package net.azib.java.students.t980814.homework;

/**
 * InputOutputMethod
 *
 * @author dell
 */
public class DecaInputOutputMethod {

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

	public void setInputMethod(DecaInputMethod i, String param) {
		inputMethod = i;
		inputParameter = param;
	}
		
	public void setOutputMethod(DecaOutputMethod o, String param) {
		outputMethod = o;
		outputParameter = param;
	}
		
	public boolean isIOMethodLegal() {
		return ((inputMethod != DecaInputMethod.UNKNOWN) &&
		        (outputMethod != DecaOutputMethod.UNKNOWN));
	}
	
/* For debug purposes */
/*	public String toString() {
		return ((inputMethod.toString() + ((inputParameter == null) ? "" : (" - " + inputParameter))) + 
				System.getProperty("line.separator") +
				(outputMethod.toString() + ((outputParameter == null) ? "" : (" - " + outputParameter)))); 
	} */
}
