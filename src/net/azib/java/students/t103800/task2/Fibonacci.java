package net.azib.java.students.t103800.task2;

import java.math.BigInteger;

/**
 * User: Jaan Aigro 103800
 * Date: 14.02.11
 * Time: 12:41
 */
public class Fibonacci {

    /**
     * Calculates a fibonacci number;
     *
     * @param index Position of the number in the fibonacci sequence.
     * @return A fibonacci number. Returns null if the value of the index is negative.
     */
    public static BigInteger generate(int index) {
        BigInteger bi[] = new BigInteger[2];
        bi[0] = BigInteger.ZERO;
        bi[1] = BigInteger.ONE;

        if (index >= 2) {
            for (int i = 2; i <= index; i++) {
                BigInteger bim = BigInteger.ZERO;
                bim = bim.add(bi[0]);
                bim = bim.add(bi[1]);
                bi[0] = bi[1];
                bi[1] = bim;
            }
            return bi[1];
        } else if (index >= 0) {
            return bi[index];
        } else return null;
    }

}