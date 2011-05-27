package net.azib.java.students.t103800.homework.decathlon;

/**
 * This exception is used to describe problems that may occur while importing data.
 * @see Importer
 *
 * @author Jaan Aigro
 * @version 1.0
 * @since 22/05/2011
 */
public class ImporterException extends Exception{

	/**
	 * Constructs a new exception with the specified detail message.
	 * @param message the detail message.
	 */
	public ImporterException(String message) {
		super(message);
	}
}