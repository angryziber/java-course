package net.azib.java.students.t030630;

import java.io.PrintStream;
/**
 * a class to show how to use <i>javadoc</i> in Java
 * 
 * @version 1.0
 * @author Kasutaja
 */
public class JavadocSample {
	/**
	 * Displays Hello to the user
	 * 
	 * @deprecated please use {@link System#out} method {@link PrintStream}
	 *             directly
	 * @param name
	 *            user's name
	 */
	private static void displayHello(String name) {
		System.out.println("Hello, user " + name);

	}
	
	private static void displayNumbers(){
		int i= 0;
		while(i++<10)
			System.out.println(i);
		
		i=1;
		do
			System.out.println(i);
		while(i++<10);
	
	}
	

	/**
	 * The entry point to our program
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayHello("Sergei");
		displayNumbers();
	}

}
