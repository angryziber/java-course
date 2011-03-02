package net.azib.java.students.t107110.hometask_1002;

import java.math.BigInteger;

/**
 * Calculates a factorial
 *
 * @author t107110
 */
public class Factorial {
    /**
     * 0!
     */
    private static final BigInteger F0 = BigInteger.ONE;

    /**
     * a factorial
     */
    private final BigInteger value;

    /**
     * Calculates the factorial of a number specified as parameter n
     * <p/>
     * Factorials are calculated in iterations using the definition n! = 1 ⋅ 2 ⋅ ... ⋅ n
     * <p/>
     * Note: The class objects are immutable
     *
     * @param n A number to calculate the factorial of
     */
    public Factorial(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorials of negative numbers are not supported");
        }

        // initialized with 0!
        BigInteger f = F0;
        for (int i = 1; i <= n; i++) {
            // i! = (i-1)! ⋅ i
            f = f.multiply(BigInteger.valueOf(i));
        }
        // n! because here i = n and i! = n!
        value = f;
    }

    /**
     * Gives the calculated factorial
     *
     * @return the factorial
     */
    public BigInteger getValue() {
        return value;
    }
}
