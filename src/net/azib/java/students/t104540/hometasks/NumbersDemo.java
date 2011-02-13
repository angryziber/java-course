package net.azib.java.students.t104540.hometasks;

/**
 * User: t104540
 * Date: 11.02.11
 * Time: 21:49
 */
public class NumbersDemo {
    static final Integer INDEX = 100;

    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
        System.out.print(INDEX + "th fibonacci number is ");
        System.out.println(fibo.getFibonacciNumber(INDEX, true));

        Factorial fact = new Factorial();
        System.out.print("Factorial of " + INDEX + " is ");
        System.out.println(fact.getFactorialOf(INDEX));

    }
}
