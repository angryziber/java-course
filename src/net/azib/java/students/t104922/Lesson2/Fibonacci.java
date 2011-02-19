package net.azib.java.students.t104922.Lesson2;

import java.math.BigInteger;

/**
 * @author eRIK 104922
 * Function that calculates fibonacci numbers
 */

public class Fibonacci {
    public static void main(String[] args) {
        int x = 0;
        do {
            System.out.println(x + "th Fibonacci number is " + fibonacci(x));
            x++;
        } while (x <= 100);
    }

    public static BigInteger fibonacci(int b) {
        BigInteger i = new BigInteger("1");
        BigInteger j = new BigInteger("0");
        BigInteger n;
        int m;
        for (m = 1; m <= b; m++) {
            n = i.add(j);
            i = j;
            j = n;

        }
        return j;
    }
}
