package net.azib.java.students.t073639.taskFactFibo;

/**
 * NumbersDemo
 * 
 * @author t073639
 */
public class NumbersDemo {
	static final int NUMBER = 100;

	public static void main(String[] args) {
		Fibonacci objFibo = new Fibonacci();
		System.out.println(objFibo.calculateNumber(NUMBER));
		Factorial objFact = new Factorial();
		System.out.println(objFact.calculateNumber(NUMBER));
	}
}