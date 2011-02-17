package net.azib.java.students.t103597.src;

import java.math.BigInteger;

//Need to use BigInteger

public class Factorial {
    public void print100thsNumber(){

    BigInteger factnr = new BigInteger("1");
    BigInteger i = new BigInteger("100");


        for(i.valueOf(100);
            i.compareTo(BigInteger.ZERO)>0;
            i=i.subtract(BigInteger.ONE)){

            factnr = factnr.multiply(i);
        }

    System.out.println("Factorial = "+factnr);
    }
}

