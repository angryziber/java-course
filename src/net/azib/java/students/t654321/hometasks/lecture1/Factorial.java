/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture1;

import java.math.BigDecimal;

/**
 *
 * @author Karl
 */
public class Factorial {

    public static void factorialCalculator(int factorialNumber) {
        BigDecimal factorial = BigDecimal.ONE;
        for (int i = 1; i <= factorialNumber; i++) {
            factorial = factorial.multiply(new BigDecimal(i));
            if (i == factorialNumber) {
                System.out.println("Factorial of " + i + " is :" + factorial);
            }
        }
    }

    public static void main(String... args) {
        int factorial = 100;
        factorialCalculator(factorial);
    }
}
