package net.azib.java.students.t093052.homework.action.input;

/**
 * This class is RuntimeException and represents exceptions which could occur
 * during reading data from input 
 */
public class InputDataException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InputDataException(String message, Throwable cause) {
		super(message);
		initCause(cause);
	}
}
