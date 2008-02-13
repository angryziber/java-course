package net.azib.java.students.t040719.lessons;

/**
 * LessonOne
 *
 * @author Romi Agar
 */
public class LessonOne {
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		Factorial fa = new Factorial();
		System.out.println("Fibonacci 100. nr: " + f.calculateFib(100));
		System.out.println("First 100 Fibonacci numbers: " + f.getFiboList(100));
		System.out.println("Factorial of 100 is: " + fa.calculateFact(100));
		System.out.println("First 100 Factorials are: " + fa.getFactList(100));
	}
}
