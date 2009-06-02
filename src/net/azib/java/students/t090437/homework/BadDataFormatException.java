package net.azib.java.students.t090437.homework;

/**
 * BadInputFormatException
 * 
 * This exception is used for reporting when incorrect 
 * strings are used in parsing data for objects MyTime and MyDouble.
 *
 * @author Ronald
 */
public class BadDataFormatException extends Exception {

	private String message;
	
	/**
	 * Creates new exception object
	 * @param string Message associated with the new exception object.
	 */
	public BadDataFormatException(String string) {
		message = string;
	}
	/**
	 * Returns error message associated with the exception object.
	 */
	public String toString() {
		return message;
	}

}
