package net.azib.java.students.t104607;

// @author 104607 IASM

import java.math.BigInteger;

public class Factorial {
    public BigInteger compute(int i) throws IllegalArgumentException {
        if (i<0) throw new IllegalArgumentException("use positive number");
        BigInteger curr = BigInteger.ONE;
        for (;i>0;i--) curr = curr.multiply(BigInteger.valueOf(i));
        return curr;
    }
}
