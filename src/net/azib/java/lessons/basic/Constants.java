package net.azib.java.lessons.basic;

/**
 * Constants
 *
 * @author anton
 */
public class Constants {
	static String HELLO;
	static String WORLD;
	
	static {
		HELLO = "Hello";
		WORLD = "World";
	}

	static final String GREETING_MESSAGE = HELLO + ", " + WORLD;
}
