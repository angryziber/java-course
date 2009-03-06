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
public class Fibonacci {
  
    public static BigInteger fibonacciSeriesCalculator(int numberOfElement) {
        if (numberOfElement < 0) {
            System.out.println("Invalid input");
            return new BigInteger("-1");
        }
        BigInteger firstFibonacciElement = BigInteger.ZERO;
        BigInteger secondFibonacciElement = BigInteger.ONE;
        BigInteger fibonacciElement = BigInteger.ZERO;
        for (int i = 2; i < numberOfElement; i++) {
            fibonacciElement = firstFibonacciElement.add(secondFibonacciElement);
            firstFibonacciElement = secondFibonacciElement;
            secondFibonacciElement = fibonacciElement;
        }
        switch (numberOfElement) {
            case 0:
                return firstFibonacciElement;
            case 1:
                return secondFibonacciElement;
            default:
                return fibonacciElement;
        }
    }

    public static void main(String... args) {
        int numberOfElement = 100;
        System.out.println("Fibonacci series " + numberOfElement + "th element is :" + fibonacciSeriesCalculator(numberOfElement).toString());
    }
}
