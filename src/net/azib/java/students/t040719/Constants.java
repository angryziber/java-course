package net.azib.java.students.t040719;

/**
 * Constants
 *
 * @author t040719
 */
public class Constants {
	static String HELLO;
	static String WORLD;
	static final String GREETS = HELLO + ", " + WORLD; //annab null, null; staatilistel asjadel on initsialiseerimise järjekord tähtis
	static final String GREETING_MESSAGE = "Hello JAVA Guru!";
	
	static {
		HELLO = "Hello";
		WORLD = "World";
	}
	static final String GREET = HELLO + ", " + WORLD;
	
}
