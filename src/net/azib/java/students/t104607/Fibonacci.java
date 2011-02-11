package net.azib.java.students.t104607;

// @author 104607 IASM

import java.math.BigInteger;

public class Fibonacci {
    public BigInteger compute(int i) throws IllegalArgumentException {
        if (i<0) throw new IllegalArgumentException("use positive number");
        BigInteger prev = BigInteger.ZERO;
        if (i == 0) return prev;
        BigInteger curr = BigInteger.ONE;
        if (i == 1) return curr;
        BigInteger temp;
        for (i--;i>0;i--) {
            temp = curr;
            curr = curr.add(prev);
            prev = temp;
        }
        return curr;
    }
}
