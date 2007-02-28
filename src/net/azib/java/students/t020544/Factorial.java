package net.azib.java.students.t020544;

import java.io.IOException;
import java.math.BigInteger;

/**
 * Factorial
 * 
 * @author Julija Kondratjeva
 */
public class Factorial {

	/**
	 * @param args
	 * @throws Exception
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException, Exception {

		System.out.println("The program calculates factorial.");
		
		BigInteger[] factorial = new BigInteger[104];
		factorial[0] = BigInteger.ONE;
		factorial[1] = BigInteger.ONE;
		GetDataFromUser f = new GetDataFromUser();
		int n = f.getNumberFromUser();
				
		if (n < 0) {
			System.out.println("Factorial doesn't exist. Number You enter should be greater then zero");

		}

		else if (n == 0) {
			System.out.println(factorial[0]);
		}

		else {
			for (int i = 1; i < 101; i++) {

				factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i));

				// System.out.println(i + "! = " + factorial[i]);
			}
			System.out.println(n + "! = " + factorial[n]);
		}

	}
}
