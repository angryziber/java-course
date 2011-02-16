package net.azib.java.students.t104922;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: PS1c0m
 * Date: 16.02.11
 * Time: 13:03
 */
public class Fibonacci {
    public static void main(String[] args) {

        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        int n = 0;
        do {
            System.out.println(a + " ");
            System.out.println(b + " ");
            a = b.add(a);
            b = b.add(a);
            n++;
        }
        while (n <= 100);
    }
}
