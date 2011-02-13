package net.azib.java.students.t104540.hometasks;

import sun.nio.cs.ext.Big5;

import java.math.BigInteger;

/**
 * User: t104540
 * Date: 11.02.11
 * Time: 21:35
 */
public class Fibonacci {
    public BigInteger getFibonacciNumber(Integer index, Boolean startFromZero){
        BigInteger lastFibonacciNumber = new BigInteger("0");
        BigInteger currentFibonacciNumber = new BigInteger("1");

        for(int i=0;i<index;i++){
            BigInteger temp = new BigInteger(currentFibonacciNumber.toString());
            currentFibonacciNumber = currentFibonacciNumber.add(lastFibonacciNumber);
            lastFibonacciNumber = temp;
        }
        if(startFromZero){
            return lastFibonacciNumber;
        }
        else{
            return currentFibonacciNumber;
        }
    }
}
