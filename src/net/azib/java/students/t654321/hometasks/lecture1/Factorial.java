/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture1;

import java.math.BigInteger;

/**
 *
 * @author Karl
 */
public class Factorial {

    public static BigInteger factorialCalculator(int factorialNumber) {
        if (factorialNumber < 0){
            System.out.println("Invalid input");
            return new BigInteger("-1");
        }
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= factorialNumber; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    public static void main(String... args) {
        int factorial = 100;
        System.out.println("Factorial of " + factorial + " is :" + factorialCalculator(factorial).toString());
    }
}
