package net.azib.java.students.t104923.second;

import java.math.BigInteger;

public class Factorial {
    private static BigInteger a = new BigInteger("100");
    private static BigInteger i = new BigInteger("100");

    public static void main(String[] args) {
         for(int n=100; n > 1; n--){
             a = a.multiply(i = i.subtract(BigInteger.ONE));
         }
         System.out.println("Factorial of a hundred is " + a);
    }
}
