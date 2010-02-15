package net.azib.java.students.t073639.tasks;


/**
 * NumbersDemo
 * 
 * @author t073639
 */
public class NumbersDemo {
	static final int NUMBER = 100;

	public static void main(String[] args) {
		Fibonacci objFibo = new Fibonacci();
		System.out.println(objFibo.getFibonacciNumber(NUMBER));
		Factorial objFact = new Factorial();
		System.out.println(objFact.getFactorialNumber(NUMBER));
	}
}