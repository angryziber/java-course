package net.azib.java.students.t093052.lecture2;

import java.math.BigInteger;

/**
 * NumbersDemo
 *
 * @author Kostja
 */
public class NumbersDemo {

	public static void main(String[] args) {
		new NumbersDemo().run();
	}

	private void run() {
		System.out.println("Fibonacci calculation...");
		printNumbers(Fibonacci.calculateNumbers(100));
		
		System.out.println("Factorial calculation...");
		printNumbers(Factorial.calculateNumbers(100));
	}

	private void printNumbers(BigInteger[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if ((i + 1) % 10 == 0) {
				System.out.println(numbers[i] + " ");
			} else {
				System.out.print(numbers[i] + " ");
			}
		}
		System.out.println("\n");
	}
}
