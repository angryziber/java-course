/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture1;

import java.math.BigDecimal;
import java.util.Iterator;

/**
 *
 * @author Karl
 */
public class Fibonacci {

    public static void calculateFibonacciElement(int numberOfElement) {
        BigDecimal[] fibonacciElement = new BigDecimal[numberOfElement];
        fibonacciElement[0] = BigDecimal.ZERO;
        fibonacciElement[1] = BigDecimal.ONE;
        for (int i = 2; i < fibonacciElement.length; i++) {
            fibonacciElement[i] = fibonacciElement[i - 2].add(fibonacciElement[i - 1]);
            if (i == numberOfElement - 1) {
                System.out.println("Fibonacci series 100th element is :" + fibonacciElement[i].toString());
            }
        }
    }

    public static void main(String... args) {
        int numberOfElement = 120;
        calculateFibonacciElement(numberOfElement);
    }
}
