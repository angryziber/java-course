package net.azib.java.students.t103781;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Robert Kullamaa 103781IASB21
 */
public class NumbersDemo {
    public static void main(String[] args) {

    FibonacciClass fib = new FibonacciClass();
    BigInteger number = fib.Show100();
    System.out.println("100th fibonacci number : " + number);

    FactorialClass fact = new FactorialClass();
    number = fact.fact100();
        System.out.println("100th factorial number : " + number);
    }
}
