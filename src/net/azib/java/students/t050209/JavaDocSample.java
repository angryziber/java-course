package net.azib.java.students.t050209;

import java.io.PrintStream; /*ctrl+shift+m printstreami peal*/
import java.math.BigInteger;

/**
 * Näide Javadoci kasutamisest <b>Java</b>s
 *
 * @version 1.0
 * @author t050209
 */
public class JavaDocSample {

	/**
	 * Displays hello to user
	 * @param name user's name
	 * @deprecated please use something else in future, {@link System#out} method {@link PrintStream#println()} directly
	 */
	private static void displayHello(String name) {
		System.out.println("Hello, " + name + "!");
	}
	
	private static void showNumbersUsingWhile() {
		/**
		 * displays numbers using While
		 */
		int i = 0;
		
		while (i<10) {
			System.out.println(i);
			i++;	
		}
		
	}
	
	private static void showNumbersUsingDoWhile() {
		/**
		 * displays numbers using Do While
		 */
		int i = 0;
		
		do {
			System.out.println(i);
			i++;
		}while (i<10);
		
	}
	
	private static void Fibonacci() {
		/**
		 * 0,1,1,2,3,5,8 jne
		 */
		BigInteger x = new BigInteger("0");
		BigInteger y = new BigInteger("1");
		BigInteger z = new BigInteger("0");
		
		// old style
		for (int i = 0; i < 100; i++) {
			z = x.add(y);
			x = y;
			y = z;
			//System.out.println(z);
		}
		System.out.println(z);
		
		//new style
		BigInteger[] ints = {BigInteger.ONE, BigInteger.ZERO};
		for (BigInteger i : ints) {
			System.out.println(i);			
		}
	}
	
	/**
	 * Entry point to our program
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        displayHello("Muhv");
        showNumbersUsingWhile();
        showNumbersUsingDoWhile();
        Fibonacci();
	}

}
