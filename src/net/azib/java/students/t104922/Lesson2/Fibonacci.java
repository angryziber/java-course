package net.azib.java.students.t104922;

import java.math.BigInteger;

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
/*
package net.azib.java.students.t104922.Lesson2;

import java.math.BigInteger;
/*
 * User: PS1c0m
 * Date: 16.02.11
 * Time: 13:03
 */
/*
public class Fibonacci {
    public static void main(String[] args) {
        int x = 0;
        do {
        System.out.println(fibonacci(x) + " ");
            x = x + 1;
        }
        while (x <= 100);

    }
    public static BigInteger fibonacci(int x){
        BigInteger i;
        BigInteger b;
            i = b.add(i);
            b = b.add(i);
        return b;
    }
}
*/