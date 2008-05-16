package net.azib.java.students.t030604.homework.writer;

/**
 * describes exceptional situations during output process.
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public class WriterException extends Exception {
	
	/**
	 * serial version uid.
	 */
	private static final long serialVersionUID = 5798167176095323255L;

	public WriterException(String message, Throwable cause) {
		super(message, cause);
	}

}
