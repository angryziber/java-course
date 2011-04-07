package net.azib.java.students.t104540.hometask2;

import java.math.BigInteger;

/**
 * User: t104540
 * Date: 11.02.11
 * Time: 21:35
 */
public class Fibonacci {
    public BigInteger getFibonacciNumber(int index){
        BigInteger lastFibonacciNumber = new BigInteger("0");
        BigInteger currentFibonacciNumber = new BigInteger("1");

        for(int i=0;i<index;i++){
            BigInteger temp = new BigInteger(currentFibonacciNumber.toString());
            currentFibonacciNumber = currentFibonacciNumber.add(lastFibonacciNumber);
            lastFibonacciNumber = temp;
        }

            return currentFibonacciNumber;

    }
}
