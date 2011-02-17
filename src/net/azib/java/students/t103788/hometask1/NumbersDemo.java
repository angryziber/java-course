package net.azib.java.students.t103788.hometask1;

/**
 * Created by IntelliJ IDEA.
 * User: Rene Lehtma 103788
 * Date: 16.02.11
 */
public class NumbersDemo {

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci(100);
		Factorial factorial = new Factorial(100);

		System.out.println("the 100th Fibonacci number: " +
				fibonacci.toString(100));
		System.out.println("and the 100th factorial number: " +
				factorial.toString(100));
	}
}
