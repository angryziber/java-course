package net.azib.java.students.t107110;

/**
 * Contains a Fibonacci number
 *
 * @author t107110
 */
public strictfp class FastFibonacci {
    /**
     * √5 for performance
     */
    private static final double SQRT5 = Math.sqrt(5);
    /**
     * φ = (1 + √5) / 2
     */
    private static final double φ = (1 + SQRT5) / 2;

    /**
     * a Fibonacci number
     */
    private final long value;

    /**
     * Calculates the Fibonacci number corresponding to the Fibonacci sequence index specified as parameter n
     * <p/>
     * Fibonacci numbers are calculated using closed-from expression F(n) = ⎣φⁿ/√5 + ½⎦
     * <p/>
     * Note: The class objects are immutable
     * <p/>
     * Note: Because of internal representation precision, Fibonacci numbers for over 70 are not supported
     *
     * @param n Fibonacci sequence index
     */
    public FastFibonacci(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative Fibonacci numbers are not supported");
        }
        if (n > 70) {
            throw new IllegalArgumentException("Cannot calculate Fibonacci number over 70");
        }

        // F(n) = ⎣φⁿ/√5 + ½⎦
        value = Math.round(Math.pow(φ, n) / SQRT5);
    }

    /**
     * Gives the Fibonacci number
     *
     * @return the Fibonacci number
     */
    public long getValue() {
        return value;
    }
}
