package net.azib.java.students.t050545.hometasks.fibofacto;

import java.math.BigInteger;


/**
 * Fibonacci
 * 
 * @author libricon
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fibonacci.printFibonacci(0);
		Fibonacci.printFibonacci(1);
		Fibonacci.printFibonacci(2);
		Fibonacci.printFibonacci(3);
		Fibonacci.printFibonacci(20);
		Fibonacci.printFibonacci(100);

	}

	public static BigInteger calculateFibonacci(int number) {
		BigInteger previous = BigInteger.ZERO;
		if (number == 0)
			return previous;
		BigInteger next = BigInteger.ONE;
		for (int i = 1; i < number; i++) {
			next = next.add(previous);
			previous = next.subtract(previous);
		}
		return next;
	}

	public static void printFibonacci(int number) {
	    if(number == 0 ) System.out.println("The Fibonacci number zero   is \t: " + calculateFibonacci(number));
		else if(number == 1) System.out.println("The first Fibonacci number  is \t: " + calculateFibonacci(number));
		else if(number == 2) System.out.println("The second Fibonacci number is \t: " + calculateFibonacci(number));
		else if(number == 3) System.out.println("The third Fibonacci number  is \t: " + calculateFibonacci(number));
		else  System.out.println("The "+number+"th Fibonacci number  is \t: " + calculateFibonacci(number));
	 }

}