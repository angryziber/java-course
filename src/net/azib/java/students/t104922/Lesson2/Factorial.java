package net.azib.java.students.t104922.Lesson2;

import java.math.BigInteger;

/**
 * @author eRIK 104922
 * Function that calculates factorial numbers
 */

public class Factorial {
    public static void main(String[] args) {
        int x = 0;
        do {
            System.out.println(x + "! = " + factorial(x));
            x = x + 1;
        }
        while (x <= 100);
    }

    public static BigInteger factorial(int x) {
        if (x == 0)
            return BigInteger.ONE;
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= x; i++) fact = fact.multiply(BigInteger.valueOf(i));
        return fact;
    }
}
