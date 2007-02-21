package net.azib.java.students.t030632;

import java.io.PrintStream;
import java.util.Date;

/**
 * JavaDocSample
 * A class to show how to use <B>Javadoc</B>
 * @version 1.0
 * @author Toni
 */
public class JavaDocSample {
	
	/**
	 * Displays hello to the user
	 * @param name User's name
	 * @deprecated please use <pre>{@link System#out} method {@link PrintStream#println()}</pre>
	 */
	private static void displayHello(String name){
		System.out.println("Hello Fellow "+name);
		new Date();
	}

	/**
	 * The entry point to our program
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		displayHello("Anton");
		int i=0;
		while(i<10){
			i++;
			System.out.print(i+" ");
		}
		int ii=0;
		do{
			ii++;
		    System.out.print(" "+ii);
		}
		while(ii< 10);
		


	}

}
