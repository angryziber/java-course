package net.azib.java.students.t104540.hometasks;

import java.math.BigInteger;

/**
 * User: t104540
 * Date: 11.02.11
 * Time: 22:03
 */
public class Factorial {
    public BigInteger getFactorialOf(Integer integer){
        BigInteger fact = new BigInteger("1");
        BigInteger counter = new BigInteger("1");

        while(counter.intValue()<integer){
            fact = fact.multiply(counter);
            counter = counter.add(BigInteger.ONE);
        }
        return fact;
    }
}
