package net.azib.java.students.t090437.homework;

/**
 * MyException
 * 
 * This exception is used for reporting any errors what happen in the 
 * functionality of loading, processing or storing the competition data. 
 *
 * @author Ronald
 */
public class MyException extends Exception {
	private String message;
	
	/**
	 * Creates new exception object
	 * @param string Message associated with the new exception object.
	 */
	public MyException(String string) {
		message = string;
	}
	
	/**
	 * Returns error message associated with the exception object.
	 */
	public String toString() {
		return message;
	}
}
