package net.azib.java.students.t020544;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * FibonacciCalc
 * 
 * @author Julija Kondratjeva
 */
public class FibonacciCalc {

	public int getNumberFromUser() throws Exception, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int userNumber;
		System.out.println("Which Fibonacci number do You want to know?");
		userNumber = Integer.parseInt(in.readLine());
		return userNumber;
	}

	public BigInteger fibonacciNumber(int number) {

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

}
