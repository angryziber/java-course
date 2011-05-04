package net.azib.java.students.t092877.lecture2;

public class NumberDemo {

	public final static int COMPUTE_TERM = 100;

	public static void main(String[] args) {

		Factorial factorial = new Factorial();
		Fibonacci fibonacci = new Fibonacci();

		System.out.println("Factorial " + COMPUTE_TERM + "-th term: " + factorial.compute(COMPUTE_TERM));
		System.out.println("Fibonacci " + COMPUTE_TERM + "-th term: " + fibonacci.compute(COMPUTE_TERM));
	}
}

