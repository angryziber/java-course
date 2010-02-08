package net.azib.java.students.t092874;

/**
 * NumbersDemo 
 * 08.02.2010 
 * Lecture 2: Java Basics, Program flow
 * 
 * @author Aleksandr Gladki
 */
public class NumbersDemo {
	public static void main(String[] args) {
		System.out.println("Fibonacci 100 = " + new Fibonacci().calulate(100));

		System.out.println("Factorial 100! = " + new Factorial().calculate(100));
	}
}
