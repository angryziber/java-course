package net.azib.java.students.t105870.Lecture2;

import java.math.BigInteger;

public class Factorial {
    public BigInteger launch(int count){

        BigInteger big = BigInteger.valueOf(count);
        BigInteger nNumber = BigInteger.ONE;

        while(0 < big.intValue()){
            nNumber = nNumber.multiply(big);
            big = big.subtract(BigInteger.ONE);
        }

        return nNumber;
    }
}