package net.azib.java.students.t104540.hometask2;

/**
 * User: t104540
 * Date: 11.02.11
 * Time: 21:49
 */
public class NumbersDemo {
    static final int INDEX = 100;


	public static void main(String[] args) {
        long start = System.currentTimeMillis();
	    Fibonacci fibo = new Fibonacci();
        System.out.print(INDEX + "th fibonacci number is ");
        System.out.println(fibo.getFibonacciNumber(INDEX));

        Factorial fact = new Factorial();
        System.out.print("Factorial of " + INDEX + " is ");
        System.out.println(fact.getFactorialOf(INDEX));

	    System.out.println(System.currentTimeMillis()-start);
    }
}
