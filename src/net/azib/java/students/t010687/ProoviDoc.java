package net.azib.java.students.t010687;

import java.io.PrintStream;
//import java.util.Date;


/**
 * A class to show ho to use <i>javadoc</i> works in Java
 *
 * @version 1.0

 * @author t010687
 */
public class ProoviDoc {

	/**
	 * Entry point to our program
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		//displayHello("Matu");
		//Fibonaccii.numbersToHundred();
		doSomething(1,2,3,4,5);
		
	}
	/**
	 * Displays hello to the user
	 * @deprecated please use {@link System#out}  method  {@link PrintStream#println()} directly
	 */
	private static void displayHello(String ... args) {
		//System.out.println("Hello " + name +"!");
		System.out.printf("%s %s %s %s ", args[0], ": See","On","N2ide");
		
		//new Date();
	}
	private static void doSomething(int...ints){
		for (int intx: ints){
			System.out.println(intx);
		}
	}
	

}

