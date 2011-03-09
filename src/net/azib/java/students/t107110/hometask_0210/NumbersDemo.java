package net.azib.java.students.t107110.hometask_0210;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.Format;

/**
 * Prints some Fibonacci number
 *
 * @author t107110
 */
public class NumbersDemo {
    /**
     * Integer number format separating thousand groups
     */
    private static final Format FORMAT = new DecimalFormat("#,##0");

    /**
     * Application entry point
     * <p/>
     * Prints F(100) Fibonacci number and 100! factorial
     * <p/>
     * Note: Arguments are ignored
     *
     * @param args Ignored
     */
    public static void main(final String[] args) {
        // F(100) Fibonacci number
        printFibonacci(100);

        // 100! factorial
        printFactorial(100);
    }

    /**
     * Calculates a Fibonacci number specified by parameter n and measures the calculation time
     *
     * @param n Fibonacci sequence index
     */
    private static void printFibonacci(final int n) {
        final long startTime = System.nanoTime();
        final BigInteger fibonacci = new Fibonacci(n).getValue();
        final long stopTime = System.nanoTime();
        print("F(" + n + ")", fibonacci, startTime, stopTime);
    }

    /**
     * Calculates the factorial of a number specified by parameter n and measures the calculation time
     *
     * @param n A number to calculate the factorial of
     */
    private static void printFactorial(final int n) {
        final long startTime = System.nanoTime();
        final BigInteger factorial = new Factorial(n).getValue();
        final long stopTime = System.nanoTime();
        print(n + "!", factorial, startTime, stopTime);
    }

    /**
     * Prints a calculated value together with its short description and time used for the value calculation
     *
     * @param description Printed value description
     * @param value       Calculated value to print
     * @param startTime   Time in nanoseconds when the value calculation has been started
     * @param stopTime    Time in nanoseconds when the value calculation has completed
     */
    private static void print(final String description, final BigInteger value,
                              final long startTime, final long stopTime) {
        System.out.println(description + ": " + FORMAT.format(value) +
                " (" + FORMAT.format(stopTime - startTime) + " ns)");
    }
}
