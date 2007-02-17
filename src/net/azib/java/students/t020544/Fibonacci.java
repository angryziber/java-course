package net.azib.java.students.t020544;

import java.math.BigInteger;

/**
 * Fibonacci
 * 
 * @author Julija Kondratjeva
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BigInteger[] rezult = new BigInteger[102];
		rezult[0] = BigInteger.ZERO;
		rezult[1] = BigInteger.ONE;

		
		for(int i = 0; i<100; i++) {
			rezult[i+2] = rezult[i+1].add(rezult[i]);
			//System.out.println(i + ": " + rezult[i]);
		}
		System.out.println("100th Fibonacci number is "+rezult[100]);
	}


}
