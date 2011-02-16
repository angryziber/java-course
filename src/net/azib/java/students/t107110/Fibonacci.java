package net.azib.java.students.t107110;

import java.math.BigInteger;

/**
 * Calculates a Fibonacci number
 *
 * @author t107110
 */
public class Fibonacci {
    /**
     * F(0)
     */
    private static final BigInteger F0 = BigInteger.ZERO;

    /**
     * F(1)
     */
    private static final BigInteger F1 = BigInteger.ONE;

    /**
     * a Fibonacci number
     */
    private final BigInteger value;

    /**
     * Calculates the Fibonacci number corresponding to the Fibonacci sequence index specified as parameter n
     * <p/>
     * Fibonacci numbers are calculated in iterations using the definition F(n) = F(n-1) + F(n-2)
     * <p/>
     * Note: The class objects are immutable
     *
     * @param n Fibonacci sequence index
     */
    public Fibonacci(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative Fibonacci numbers are not supported");
        }

        // Special case F(0)
        if (n == 0) {
            value = F0;
            return;
        }
        // Special case F(1)
        if (n == 1) {
            value = F1;
            return;
        }

        // F(i-2) initialized with F(0)
        BigInteger fim2 = F0;
        // F(i-1) initialized with F(1)
        BigInteger fim1 = F1;
        // F(i)
        BigInteger fi = null;
        for (int i = 2; i <= n; i++) {
            // F(i) = F(i-1) + F(1-2)
            fi = fim1.add(fim2);
            // F(i-1) -> F(i-2)
            fim2 = fim1;
            // F(i) -> F(i-1)
            fim1 = fi;
        }
        // F(n) because here i = n and F(i) = F(n)
        value = fi;
    }

    /**
     * Gives the calculated Fibonacci number
     *
     * @return the Fibonacci number
     */
    public BigInteger getValue() {
        return value;
    }
}
