package net.azib.java.students.t092855.homework;

/**
 * Error enumeration.
 * Contains the errors and error messages.
 *
 * @author t092855
 */
public enum Error {
	ERROR_NUMBER_FORMAT ("Error: number format is wrong.");

	private final String errorText;

	Error(String s) {
		this.errorText = s;
	}

	public String getErrorText() {
		return errorText;
	}
}
