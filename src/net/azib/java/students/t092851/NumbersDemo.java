package net.azib.java.students.t092851;

/**
 * NumbersDemo
 *
 * @author t092851
 */
public class NumbersDemo {
	
	private static Factorial factorial;
	private static Fibonacci fibonacci;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		factorial = new Factorial();
		fibonacci = new Fibonacci();
		
		System.out.printf("100! = %s\n", factorial.getFactorial(100));
		System.out.printf("Fibonacci(100) = %s\n", fibonacci.getFibonacci(100));
		
		System.out.println("Factorials sequence:");
		factorial.getFactorial(10, true);
		
		System.out.println("Fibonacci sequence:");
		fibonacci.getFibonacci(10, true);
	}

}
