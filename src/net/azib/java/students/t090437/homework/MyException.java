package net.azib.java.students.t090437.homework;

/**
 * DataLoadException
 *
 * @author Ronald
 */
public class MyException extends Exception {
	private String message;
	public MyException(String string) {
		message = string;
	}
	public String toString() {
		return message;
	}
}
