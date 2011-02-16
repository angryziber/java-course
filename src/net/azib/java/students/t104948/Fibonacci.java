package net.azib.java.students.t104948;

import java.math.BigInteger;

public class Fibonacci {
    int n;
    public String doFibonacci() {
        int i;
        BigInteger fib;
        BigInteger fib_prior = new BigInteger("0");
        BigInteger temp = new BigInteger("0");
        if (n == 0) {
            fib = new BigInteger("0");
        } else if (n == 1) {
            fib = new BigInteger("1");
        } else {
            fib = new BigInteger("1");
            for (i = 1; i < n; i++) {
                temp = new BigInteger(fib.toString());
                fib = fib.add(fib_prior);
                fib_prior = new BigInteger(temp.toString());


            }
        }
        return fib.toString();
    }
}
