package net.azib.java.students.t103597.src;

import java.math.BigInteger;

public class Fibonacci {
    public void fib(){

        int nr = 100;
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("1");
        BigInteger temp;

        do{
            temp = x.add(y);
            x = y;
            y = temp;
            nr--;
        } while(nr > 0);

        System.out.println("Fibonacci = "+x);
    }
}
