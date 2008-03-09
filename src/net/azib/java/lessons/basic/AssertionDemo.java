package net.azib.java.lessons.basic;

/**
 * AssertionDemo
 *
 * @author anton
 */
public class AssertionDemo {
	
	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		
		assert "1".equals(fibonacci.compute(1));
		
		assert "1".equals(fibonacci.compute(2));
		
		assert "2".equals(fibonacci.compute(3)) : "3rd fibonacci number is incorrect";

		System.out.println("Tests passed!");
	}
}
