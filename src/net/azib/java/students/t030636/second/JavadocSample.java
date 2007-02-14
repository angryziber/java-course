package net.azib.java.students.t030636.second;

import java.io.PrintStream;
import java.util.Date;

/**
 * Test class to show how to use <i><b>Javadoc</b></i> 
 * 
 * @version 1.0
 * @author t030636
 *  
 */
public class JavadocSample {
	
	/**
	 * Welcomes the user
	 * @param name user's name
	 * @deprecated please use {@link System#out} method {@link PrintStream#println()}
	 */
	private static void doSomething(String name) {
		System.out.println("Welcome, " + name +"!!");
		new Date();
	}

	/**
	 * Program start point
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doSomething("Mina");
		
		
	}

}
