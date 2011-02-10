package net.azib.java.students.t093759.hometasks.first;


import java.math.BigInteger;

/**
 * Calculates and represents factorial.
 *
 * @author dionis
 */
public class Factorial {
    /**
     * Calculated factorial.
     */
    private BigInteger factorialsValue;
    /**
     * Number, from which factorial is calculated.
     */
    private int factorialsIndex;

    /**
     * Create factorial object from given factorials index.
     *
     * @param factorialsIndex Factorials index. It should be non-negative integer value.
     * @throws IllegalArgumentException
     */
    public Factorial(int factorialsIndex) throws IllegalArgumentException {
        calculateFactorial(factorialsIndex);
        this.factorialsIndex = factorialsIndex;
    }

    /**
     * Calculate factorial from given number.
     *
     * @param factorialsIndex Factorials index. It should be non-negative integer value.
     * @throws IllegalArgumentException
     */
    private void calculateFactorial(int factorialsIndex) throws IllegalArgumentException {
        if (badArgumentIsGiven(factorialsIndex))
            throw new IllegalArgumentException("It isn't possible to calculate factorial with negative index.");

        if (factorialsIndex == 0) {
            factorialsValue = BigInteger.ZERO;
            return;
        }

        factorialsValue = BigInteger.ONE;

        for (int i = 1; i <= factorialsIndex; i++) {
            factorialsValue = factorialsValue.multiply(new BigInteger(i + ""));
        }
    }

    /**
     * Check, is given number valid or not.
     *
     * @param factorialsIndex Factorials index.
     * @return true if given number is not valid; false if it's valid.
     */
    private boolean badArgumentIsGiven(int factorialsIndex) {
        return factorialsIndex < 0;
    }

    /**
     * Get factorials value.
     *
     * @return Factorials value.
     */
    public BigInteger getFactorialsValue() {
        return factorialsValue;
    }

    /**
     * Get factorials index.
     *
     * @return Factorials index.
     */
    public int getFactorialsIndex() {
        return factorialsIndex;
    }

    @Override
    public String toString() {
        return getFactorialsIndex() + "! = " + getFactorialsValue();
    }
}
