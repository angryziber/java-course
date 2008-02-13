package net.azib.java.students.t030633;

import java.math.BigInteger;
import java.io.*;

/**
 * Fibonacci number and sequence calculator.
 * 
 * @author t030633
 */
public class Fibonacci {

	private static BigInteger input; // Used to store user input

	// Function to calculate Fibonacci numbers using recursion
	static BigInteger fib(BigInteger n) {
		if ((n.compareTo(BigInteger.ZERO) == 0 || n.compareTo(BigInteger.ONE) == 0))
			return BigInteger.ONE;
		else
			return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.valueOf(2))));
	}

	public static void main(String[] args) {
		System.out.println("Sequence starts with 0, 1, ... with 0 being the \"first\" number.");
		fibNumber(); // Prints the n-th Fibonacci number
		fibSequenceSlow(); // Prints Fibonacci sequence of length n
		fibSequenceFast(); // - same, but faster
	}

	public static void fibNumber() { // Prints the n-th Fibonacci number
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Fibonacci number n?");

		try {
			input = BigInteger.valueOf(Integer.parseInt(br.readLine()));

			// Some sequences (including this one) see 0 as the "first"
			// Fibonacci number
			if (input.compareTo(BigInteger.ZERO) == 0)
				System.out.println("Sequence starts with the \"first\" number.");
			else {
				System.out.println("Fibonacci number " + input + " is:");
				if (input.compareTo(BigInteger.ONE) == 0) {
					System.out.println(0);
				}
				else
					System.out.println(fib(input.subtract(BigInteger.valueOf(2))));
			}
		}
		catch (NumberFormatException e) {
			System.out.println("Not a number.");
		}
		catch (IOException e) {
			System.out.println("Input error.");
		}

	}

	/*
	 * Prints Fibonacci sequence of length n by using the recursive function to
	 * calculate each member. Slow, because it needs to calculate the whole
	 * sequence again at every new member.
	 */
	public static void fibSequenceSlow() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("How many numbers in the sequence?");

		try {
			// Ask for user input on sequence length
			input = BigInteger.valueOf(Integer.parseInt(br.readLine()));
			System.out.println("The first " + input + " Fibonacci numbers are:");

			// Some sequences (including this one) see 0 as the "first"
			// Fibonacci number
			if (input.compareTo(BigInteger.ZERO) > 0)
				System.out.print(0);

			// Print the sequence
			for (BigInteger i = BigInteger.ZERO; i.compareTo(input.subtract(BigInteger.ONE)) < 0; i = i.add(BigInteger.ONE)) {
				System.out.print(", " + fib(i));
			}
			System.out.println("");
		}
		catch (NumberFormatException e) {
			System.out.println("Not a number.");
		}
		catch (IOException e) {
			System.out.println("Input error.");
		}

	}

	/*
	 * Prints the Fibonacci sequence, using add/sub method. Much faster than the
	 * recursive method.
	 */
	public static void fibSequenceFast() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("How many numbers in the sequence?");

		try {
			// Ask for user input on sequence length
			input = BigInteger.valueOf(Integer.parseInt(br.readLine()));
			System.out.println("The first " + input + " Fibonacci numbers are:");

			// Some sequences (including this one) see 0 as the "first"
			// Fibonacci number
			if (input.compareTo(BigInteger.ZERO) > 0)
				System.out.print(0);

			// Print the sequence
			BigInteger low;
			BigInteger high;
			low = high = BigInteger.ONE;

			if (input.compareTo(BigInteger.ONE) > 0)
				System.out.print(", " + 1);
			if (input.compareTo(BigInteger.valueOf(2)) > 0)
				System.out.print(", " + 1);

			for (BigInteger i = BigInteger.valueOf(2); i.compareTo(input.subtract(BigInteger.ONE)) < 0; i = i.add(BigInteger.ONE)) {
				high = high.add(low);
				low = high.subtract(low);
				System.out.print(", " + high);
			}
			System.out.println("");
		}
		catch (NumberFormatException e) {
			System.out.println("Not a number.");
		}
		catch (IOException e) {
			System.out.println("Input error.");
		}

	}

}
