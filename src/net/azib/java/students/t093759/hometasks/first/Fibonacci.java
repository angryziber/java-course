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
    private BigInteger fibonaccisNumber;
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
        if (!isFibonacciNumbersIndexValid(fibonacciNumbersIndex))
            throw new IllegalArgumentException("It isn't possible to calculate Fibonacci's number with negative index.");

        if (fibonacciNumbersIndex == 0) {
            fibonaccisNumber = BigInteger.ZERO;
            return;
        } else if (fibonacciNumbersIndex == 1) {
            fibonaccisNumber = BigInteger.ONE;
            return;
        }

        BigInteger lastFibonaccisNumber = BigInteger.ONE;        //Fibonacci(0);
        BigInteger beforeLastFibonaccisNumber = BigInteger.ZERO; //Fibonacci(1);

        for (int i = 2; i <= fibonacciNumbersIndex; i++) {
            fibonaccisNumber = lastFibonaccisNumber.add(beforeLastFibonaccisNumber);
            beforeLastFibonaccisNumber = lastFibonaccisNumber;
            lastFibonaccisNumber = fibonaccisNumber;
        }
    }

    /**
     * Check, is given index valid or not.
     *
     * @param fibonacciNumbersIndex Fibonacci numbers index. It should be non-negative integer.
     * @return true if given index is valid; false if it isn't valid.
     */
    private boolean isFibonacciNumbersIndexValid(int fibonacciNumbersIndex) {
        return fibonacciNumbersIndex >= 0;
    }

    /**
     * @return Calculated fibonacci number.
     */
    public BigInteger getFibonaccisNumber() {
        return fibonaccisNumber;
    }

    /**
     * @return Fibonacci numbers index.
     */
    public Integer getFibonacciNumbersIndex() {
        return fibonacciNumbersIndex;
    }

    @Override
    public String toString() {
        return "Fibonacci(" + fibonacciNumbersIndex + ") = " + fibonaccisNumber;
    }
}
