package net.azib.java.students.t073862;

/**
 * NumbersDemo
 *
 * @author Pets
 */
public class NumbersDemo {
	/**
	 * Prints out 100th Fibionacci and Factorial numbers.
	 */
	public void print() {
		System.out.println(new Fibionacci().calculateFibionacci(100));
		System.out.println(new Factorial().calculateFactorial(100));
	}
	public static void main(String args[]) {
		new NumbersDemo().print();
	}
}
