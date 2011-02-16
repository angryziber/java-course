package net.azib.java.students.t107678.hw1;

import java.math.BigInteger;

public class Fibonacci {

    BigInteger a = BigInteger.ZERO, b = BigInteger.ONE, c;

    public void printFibonacci(int n) {
        // it is assumed that n is positive number greater than 1;

        System.out.println(a);
        System.out.println(b);

        for (int i = 3; i <= n; i++) {
            c = a.add(b);
            a = b;
            b = c;
            System.out.println(c);
        }
    }
}

