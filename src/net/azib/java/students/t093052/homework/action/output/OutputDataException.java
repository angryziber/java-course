package net.azib.java.students.t093052.homework.action.output;

/**
 * This class is RuntimeException and represents exceptions which could occur
 * during writing data into output 
 */
public class OutputDataException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public OutputDataException(String message, Throwable cause) {
		super(message);
		initCause(cause);
	}
}
