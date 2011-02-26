package net.azib.java.students.t104877.HomeTask2;

import java.math.BigInteger;

public class Fibonacci {
    public static BigInteger calculateFibonacci(int index) {

        BigInteger a = new BigInteger("0");             //two variables for holding temporal values
        BigInteger b = new BigInteger("1");             //initially holding first 2 elements

        if (index == 0) return BigInteger.ZERO;         //if asked for zero element then return 0
        else if (index == 1) return BigInteger.ONE;     //if asked for first element then return 1
        else {                                          //if asked for n-th element (n > 1)
            for (int i = 2; i <= index; i++) {          //do while we achieve needed index
                if (a.compareTo(b) < 0)
                    a = a.add(b);                           //if a < b then a = a + b (then a > b, and a is the last calculated element)
                else b = a.add(b);                          //else b = a + b (then b > a, and b is the last calculated element)
            }
            if (a.compareTo(b) > 0) return a;           //return greatest value
            else return b;
        }
    }
}
