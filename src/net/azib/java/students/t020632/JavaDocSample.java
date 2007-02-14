package net.azib.java.students.t020632;

/**
 * A class to show how to use JavaDoc in Java
 *
 * @version 1.0
 * @author t020632
 */
public class JavaDocSample {
	
	/**
	 *  Displays hello to the user
	 *  @param name user's name
	 *  @deprecated please use {@link System#out} method {@link PrintStream#println()} directly
	 */
	
	private static void displayHello(String name){
		System.out.println("Hello, "+ name);
	}
	
	/**
	 * Entry point to the program
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayHello("Myself");
	}

}
