package net.azib.java.students.t030604.homework.parser;

/**
 * Exception used to describe exceptional situations occurred while parsing
 * the data.
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public class ParserException extends Exception {

	/**
	 * serial version uid.
	 */
	private static final long serialVersionUID = -5910415342976899399L;
	
	/**
	 * Constructor
	 * @param description - description message
	 * @param cause cause
	 */
	public ParserException(String description, Throwable cause){
		super(description, cause);
	}

}
