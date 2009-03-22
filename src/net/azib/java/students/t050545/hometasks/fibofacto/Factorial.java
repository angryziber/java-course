package net.azib.java.students.t050545.hometasks.fibofacto;

import java.math.BigInteger;

/**
 * Factorial
 *
 * @author libricon
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printFactorial(0);
		printFactorial(1);
		printFactorial(2);
		printFactorial(3);
		printFactorial(10);
		printFactorial(100);

	}

	/**
	 * This function calculate factorial.
	 * @param number factorial's number
	 * @return the factorial as BigInteger
	 */
	public static BigInteger calculateFactorial(int number) {
		BigInteger temp = BigInteger.valueOf(number);
		while (number > 1) {
			temp = temp.multiply(BigInteger.valueOf(--number));
		}
		return temp;
	}

	/**
	 * This function print on screen factorial.
	 * @param number
	 */
	public static void printFactorial(int number) {
        System.out.println("Factorial of \t"+number+"\t is " + calculateFactorial(number).toString());
	}
}
