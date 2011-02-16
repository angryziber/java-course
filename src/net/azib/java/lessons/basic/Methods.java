package net.azib.java.lessons.basic;

import java.math.BigInteger;

@SuppressWarnings({"UnusedAssignment"})
public class Methods {
    static class NumberHolder {
        int n;
    }

    static void doStuff(int n) {
        n = n + 1;
    }

    static void doStuff(BigInteger n) {
        n = n.add(BigInteger.ONE);
    }

    static void doStuff(NumberHolder holder) {
        // holder = new NumberHolder();
        holder.n++;
    }

    public static void main(String[] args) {
        int n = 0;
        doStuff(n);
        System.out.println(n);

        BigInteger big = BigInteger.ZERO;
        doStuff(big);
        System.out.println(big);

        NumberHolder holder = new NumberHolder();
        doStuff(holder);
        System.out.println(holder.n);
    }
}
