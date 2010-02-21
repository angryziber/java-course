package net.azib.java.students.t073857;

/**
 * NumbersDemo
 *
 * @author Joonas Vali
 */
public class NumbersDemo {
	public static void main(String[] args) {
		demonstrate();		
	}
	
	public static void demonstrate(){
		System.out.println("Factorial 100: "+Factorial.getFactorial(100));
		System.out.println("Fibonacci 100: "+Fibonacci.getFibonacci(6));
	}
}
