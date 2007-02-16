package net.azib.java.students.t020544;

import java.io.IOException;
/**
 * Fibonacci
 * 
 * @author Julija Kondratjeva
 */
public class Fibonacci {
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception, IOException {

		FibonacciCalc f = new FibonacciCalc();
        int usersNumber = f.getNumberFromUser();
		System.out.println(f.fibonacciNumber(usersNumber));
		
	}

}
