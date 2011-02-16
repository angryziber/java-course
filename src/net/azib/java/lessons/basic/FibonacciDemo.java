package net.azib.java.lessons.basic;

/**
 * FibonacciDemo
 *
 * @author anton
 */
public class FibonacciDemo {
	public static void main(String ... args) {
		for (int i = 0; i <= 100; i++) {
			System.out.println(new Fibonacci().compute(i));
		}
	}
}
