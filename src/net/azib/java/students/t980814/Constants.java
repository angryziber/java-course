package net.azib.java.students.t980814;

/**
 * Constants
 * 
 * @author t980814
 */
public class Constants {
	static String HELLO;
	static String WORLD;
	static final String HELLO_MESSAGE = HELLO + ", " + WORLD;
	
	static {
		HELLO = "Hello";
		WORLD = "World";
	}

	static final String GREETING_MESSAGE = HELLO + ", " + WORLD;
}
