package net.azib.java.students.t040719.lessons;

/**
 * AssertDemo
 *
 * @author t040719
 */
public class AssertDemo {
	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		System.out.println(fib.calculateFib(7));
		
		assert "5".equals(fib.calculateFib(6)) : "Ei õnnestunud fibonacci";
		
		if (!"5".equals(fib.calculateFib(6)))
			throw new RuntimeException("failed!!!");
	}
}
