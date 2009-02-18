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

    public static void calculateFibonacciElement(int numberOfElement) {
        BigInteger firstFibonacciElement = BigInteger.ZERO;
        BigInteger secondFibonacciElement = BigInteger.ONE;
        BigInteger fibonacciElement = null;
        for (int i = 2; i < numberOfElement; i++) {
            fibonacciElement = firstFibonacciElement.add(secondFibonacciElement);
            firstFibonacciElement = secondFibonacciElement;
            secondFibonacciElement = fibonacciElement;
        }
        System.out.println("Fibonacci series 100th element is :" + fibonacciElement.toString());
    }

    public static void main(String... args) {
        int numberOfElement = 100;
        calculateFibonacciElement(numberOfElement);
    }
}
