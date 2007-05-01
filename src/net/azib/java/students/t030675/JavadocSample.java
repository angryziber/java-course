package net.azib.java.students.t030675;

import java.io.PrintStream;
import java.math.BigInteger;

/**
 * A class to show how to use <i>javadoc</i> in Java
 * @version 1.0
 * @author t030675
 */
public class JavadocSample {
	
	/**
	 *Displays hello to the user 
	 *@param name user's name
	 *@deprecated please use {@link System#out#} method {@link PrintStream#println()} directly
	 */
	private static void displayHello(String name){
		System.out.println("Hello, " + name);
	}
	
	/**
	 * Entry point to our program
	 * @param args command-line arguments
	 * */
	
	public static void main(String[] args) {
		//displayHello("Myself");
		
        int N = 100;
        for (int i = 1; i <= N; i++)
            System.out.println(i + ": " + fib(i));
		
		//fiboNumber(100);
		
		

	}
	
	public static void fiboNumber(int n){
		BigInteger[] ints = {BigInteger.ONE,BigInteger.ZERO};
		for (BigInteger bigInteger : ints) {
			System.out.println(bigInteger);
		}
	}
	
    public static long fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }





	
	public void whileCycle(){
		int i=0;
		
		do {
			//i++;
			System.out.print(i + " ");
			
		}
		while (++i<10);
		
		System.out.println();
		i=0;
		
		while (++i<10) {
			//i++;
			System.out.print(i + " ");
			
		}
	}

}
