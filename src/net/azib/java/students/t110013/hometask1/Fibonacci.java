package net.azib.java.students.t110013.hometask1;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Vadim
 * Date: 13.02.11
 * Time: 12:03
 */
public class Fibonacci {
    private int fibonacciIndex;
    private BigInteger fibonacciValue;

    public Fibonacci(int receivedIndex) {
        if (receivedIndex < 0) {
            throw new IllegalArgumentException("Negative integers are not allowed!");
        }
        fibonacciIndex = receivedIndex;
    }

    public BigInteger getValue() {
        if (fibonacciValue == null) {
            BigInteger prePreviousFibonacciValue = BigInteger.ZERO;
            BigInteger previousFibonacciValue = BigInteger.ONE;
            if (fibonacciIndex == 0) {
                fibonacciValue = prePreviousFibonacciValue;
            } else if (fibonacciIndex == 1) {
                fibonacciValue = previousFibonacciValue;
            } else {
                for (int i = 2; i <= fibonacciIndex; i++) {
                    fibonacciValue = prePreviousFibonacciValue.add(previousFibonacciValue);
                    prePreviousFibonacciValue = previousFibonacciValue;
                    previousFibonacciValue = fibonacciValue;
                }
            }
        }
        return fibonacciValue;
    }

    public int getIndex() {
        return fibonacciIndex;
    }

    public String toString() {
        return "The " + fibonacciIndex + " number in the Fibonacci sequence is " + getValue();
    }
}
