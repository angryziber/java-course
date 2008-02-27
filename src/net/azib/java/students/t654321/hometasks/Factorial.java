package net.azib.java.students.t654321.hometasks;

import java.math.BigInteger;

/**
 * Factorial
 *
 * @author t999902
 */
public class Factorial {

	/**
	 * @param witchElement - index of element of factorial. 
	 * @deprecated - very bad method
	 */
	private static void calculateFactorial(int witchElement) {
		int i = 1;
		BigInteger factorial = new BigInteger("1");
		while (i < witchElement){
			BigInteger indx = new BigInteger(Integer.toString(i));
			factorial = factorial.multiply(indx);
			i++;
		}
		System.out.println(factorial);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int witchElement = 100;
		calculateFactorial(witchElement);
	}

	

}
