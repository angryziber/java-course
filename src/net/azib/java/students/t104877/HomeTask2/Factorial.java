package net.azib.java.students.t104877.HomeTask2;

import java.math.BigInteger;

public class Factorial {
    public static BigInteger calculateFactorial(int index) {
        BigInteger a = new BigInteger("1");         //variable holding already calculated factorial

        //0! = 1, 1! = 1: if index = 0 | 1, loop will be omitted
        for (int i = 2; i <= index; i++) {
            a = a.multiply(new BigInteger(Integer.toString(i))); //i! = i * (i-1)!
        }
        return a;
    }
}
