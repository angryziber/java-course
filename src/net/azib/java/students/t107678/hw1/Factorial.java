package net.azib.java.students.t107678.hw1;

import java.math.BigInteger;


public class Factorial {
    BigInteger a = BigInteger.ONE;
    // it is assumed that 0! is 1;
    // also I have assumed that n is positive number;

    public void printFactorial(int n) {
        if (n == 0) {
            System.out.println(1);
        }
        int i = 1;
        BigInteger sum = a;
        while (i <= n) {
            System.out.println(sum);
            a = a.add(BigInteger.ONE);
            sum = sum.multiply(a);
            i++;
        }


    }
}
