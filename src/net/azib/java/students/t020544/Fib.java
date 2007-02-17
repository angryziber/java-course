package net.azib.java.students.t020544;

import java.io.IOException;
import java.math.BigInteger;

/**
 * Fib
 * 
 * @author Julija Kondratjeva
 */
public class Fib {

	public static BigInteger fibonacciNumber(int number) {

		BigInteger rezult = BigInteger.ZERO;
		BigInteger firstNumber = BigInteger.ZERO;
		BigInteger secondNumber = BigInteger.ONE;

		for (int i = 1; i < number; i++) {
			rezult = firstNumber.add(secondNumber);
			firstNumber = secondNumber;
			secondNumber = rezult;
		}
		return rezult;
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception, IOException {

		System.out.println("The program calculates Fibonacci number.");
		// boolean userAnswer=true;

		// while(userAnswer){
		GetDataFromUser f = new GetDataFromUser();
		int usersNumber = f.getNumberFromUser();
		if (usersNumber < 0) {
			System.out.println("Answer doesn't exist. Number You enter should be greater then zero.");
		}
		else
			System.out.println(usersNumber + "th Fibonacci number is " + fibonacciNumber(usersNumber) + ".");

		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		// System.out.println("Do You want to continue? Y/N");
		// String stringUserAnswer=in.readLine();
	}

}
