package net.azib.java.students.t092859.hometask2;

/**
 * NumbersDemo
 *
 * @author Konstantin
 */
public class NumbersDemo {

	public static void main(String[] args) {
		
		Fibonacci fibFinder = new Fibonacci();
		Factorial factFinder = new Factorial();
		
		System.out.println("100th Fibonacci number = " + fibFinder.getFibNum(100).toString());
		System.out.println("100! = " + factFinder.getFactNum(100).toString());
		
	}
	
}
