package net.azib.java.students.t103800.homework.decathlon;

/**
 * This exception is used in the Athlete class when the validation of the
 * country code has failed.
 *
 * @see Athlete
 *
 * @author Jaan Aigro
 * @version 1.0
 * @since 23/05/2011
 */
public class CountryCodeException extends Exception{

	/**
	 * Constructs a new country code exception with the faultyCode as the reason of failure.
	 * @param faultyCode country code that the program failed to validate.
	 */
	public CountryCodeException(String faultyCode) {
		super("Country code(" + faultyCode + ") does not exist.");
	}
}