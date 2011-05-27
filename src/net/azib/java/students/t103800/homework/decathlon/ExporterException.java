package net.azib.java.students.t103800.homework.decathlon;

/**
 * This exception is used to describe problems that may occur while exporting data.
 * @see Exporter
 *
 * @author Jaan Aigro
 * @version 1.0
 * @since 22/05/2011
 */
public class ExporterException extends Exception {

	/**
	 * Constructs a new exception with the specified detail message.
	 * @param message the detail message.
	 */
	public ExporterException(String message) {
		super(message);
	}
}