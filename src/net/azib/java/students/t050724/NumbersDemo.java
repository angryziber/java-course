package net.azib.java.students.t050724;

/**
 * NumbersDemo
 *
 * @author xom
 */
public class NumbersDemo {

	private Fibonacci FibonacciCalculator;
	private Factorial FactorialCalculator;

	public static void main(String[] args)
	{
		
		NumbersDemo numDemo = new NumbersDemo();
		
		numDemo.showNumbers();

	}

	private void showNumbers()
	{
		FibonacciCalculator = new Fibonacci();
		FactorialCalculator = new Factorial();
		
		System.out.println("The 100th Fibonacci number is " + FibonacciCalculator.calculateFibonacci(100));
		System.out.println("The 100th Factorial number is " + FactorialCalculator.calculateFactorial(100));
		
	}
}
