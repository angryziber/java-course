package net.azib.java.students.t093759.hometasks.first;

import java.math.BigInteger;

/**
 * Calculates and represents Fibonacci number.
 *
 * @author dionis
 */
public class Fibonacci {
    /**
     * Calculated fibonacci number.
     */
    private BigInteger fibonacciNumber;
    /**
     * Fibonacci numbers index.
     */
    private int fibonacciNumbersIndex;

    /**
     * Create fibonacci object from given index.
     *
     * @param fibonacciNumbersIndex Fibonacci numbers index. It should be non-negative integer.
     * @throws IllegalArgumentException
     */
    public Fibonacci(int fibonacciNumbersIndex) throws IllegalArgumentException {
        calculateFibonacciNumber(fibonacciNumbersIndex);
        this.fibonacciNumbersIndex = fibonacciNumbersIndex;
    }

    /**
     * Calculate fibonacci number from given index.
     *
     * @param fibonacciNumbersIndex Fibonacci numbers index. It should be non-negative integer.
     * @throws IllegalArgumentException
     */
    private void calculateFibonacciNumber(int fibonacciNumbersIndex) {
        if (badArgumentIsGiven(fibonacciNumbersIndex))
            throw new IllegalArgumentException("It isn't possible to calculate fibonacci number with negative index.");

        if (fibonacciNumbersIndex == 0) {
            fibonacciNumber = BigInteger.ZERO;
            return;
        } else if (fibonacciNumbersIndex == 1) {
            fibonacciNumber = BigInteger.ONE;
            return;
        }

        BigInteger lastFibonacciNumber = BigInteger.ONE;        //Fibonacci(0);
        BigInteger beforeLastFibonacciNumber = BigInteger.ZERO; //Fibonacci(1);

        for (int i = 2; i <= fibonacciNumbersIndex; i++) {
            fibonacciNumber = lastFibonacciNumber.add(beforeLastFibonacciNumber);
            beforeLastFibonacciNumber = lastFibonacciNumber;
            lastFibonacciNumber = fibonacciNumber;
        }
    }

    /**
     * Check, is given index valid or not.
     *
     * @param fibonacciNumbersIndex Fibonacci numbers index. It should be non-negative integer.
     * @return true if given index is not valid; false if it's valid.
     */
    private boolean badArgumentIsGiven(int fibonacciNumbersIndex) {
        return fibonacciNumbersIndex < 0;
    }

    @Override
    public String toString() {
        return "Fibonacci(" + fibonacciNumbersIndex + ") = " + fibonacciNumber;
    }

    /**
     * @return Calculated fibonacci number.
     */
    public BigInteger getFibonacciNumber() {
        return fibonacciNumber;
    }

    /**
     * @return Fibonacci numbers index.
     */
    public Integer getFibonacciNumbersIndex() {
        return fibonacciNumbersIndex;
    }
}
