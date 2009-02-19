package net.azib.java.students.t000522;

import java.math.*;

public class Factorial {
	//value of factorial
	private static BigInteger factorial = new BigInteger("1");
	//stores cycle of loop
	private static BigInteger loopCounter = new BigInteger("0");
	//index of element
	private static int n = 10;
	
	public static void main(String[] args) {

		for (int i=1; i<=n; i++) {
			
			loopCounter = loopCounter.add(new BigInteger("1"));
			factorial = factorial.multiply(loopCounter);
			System.out.println(loopCounter + ":" + factorial);
		
		}
	}
}
