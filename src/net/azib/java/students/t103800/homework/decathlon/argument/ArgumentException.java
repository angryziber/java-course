package net.azib.java.students.t103800.homework.decathlon.argument;

/**
 * This exception is used to describe problems that can occur by using arguments.
 * @see Argument
 *
 * @author Jaan Aigro
 * @version 1.0
 * @since 27/05/2011
 */
public class ArgumentException extends Exception{

	/**
	 * Constructs a new exception with message as its detail message. Used only to describe
	 * problems with arguments.
	 * @param message the detail message.
	 */
	public ArgumentException(String message) {
		super(message);
	}
}
