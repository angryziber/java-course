package net.azib.java.students.t960644;

import java.io.PrintStream;
import java.util.Date;

/**
 * See klass on <i>JavaDoci</i> katsetamiseks.
 * @version 1.0
 * @author t960644
 */
public class JavadocSample {
	
	/**
	 * Displays hello to user
	 * @param name user's name
	 * @deprecated Use {@link System#out} method {@link PrintStream#println()} instead
	 */
	private static void displayHello(String name){
		System.out.println("Hey, " + name + "!");
		new Date();
	}
	
	/**
	 * Entry to program
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayHello("Dude");
	}

}
