package net.azib.java.lessons;

import java.io.PrintStream;

/**
 * A class to show how to use <i>javadoc</i> in Java.
 * @version 1.0
 * @author anton
 */
public class JavadocSample {
	
	/**
	 * Displays hello to the user
	 * @param name user's name
	 * @deprecated please use {@link System#out} method {@link PrintStream#println()} directly
	 */
	private static void displayHello(String name) {
		System.out.println("Hello, " + name + "!");
	}

	/**
	 * The entry point to our program
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		displayHello("Myself");
	}

}
