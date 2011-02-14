package net.azib.java.students.t103800.task2;

import java.math.BigInteger;

/**
 * User: Jaan Aigro 103800
 * Date: 14.02.11
 * Time: 12:41
 */
public class Factorial {

    /**
     * Generates a factorial number according to an index in the sequence.
     *
     * @param index Index in the sequence.
     * @return Result number. Returns null if the value of the index is negative.
     */
    public static BigInteger generate(int index) {
        if (index >= 0) {
            BigInteger bi = BigInteger.ONE;
            for (int i = index; i > 0; i--) {
                bi = bi.multiply(BigInteger.valueOf(i));
            }
            return bi;
        } else return null;
    }

}