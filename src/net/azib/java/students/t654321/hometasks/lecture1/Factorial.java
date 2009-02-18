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

    public static void factorialCalculator(int factorialNumber) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= factorialNumber; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println("Factorial of " + factorialNumber + " is :" + factorial);
    }

    public static void main(String... args) {
        int factorial = 100;
        factorialCalculator(factorial);
    }
}
