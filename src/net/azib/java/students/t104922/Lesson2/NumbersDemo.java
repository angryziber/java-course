package net.azib.java.students.t104922.Lesson2;

/**
 * @author eRIK 104922
 * Calculates both fibonacci and factorial 100th numbers.
 */
public class NumbersDemo {
    public static void main(String[] args) {
        System.out.println("Factorial 100! = " + Factorial.factorial(100));
        System.out.println("100th Fibonacci number is "+  Fibonacci.fibonacci(100));
    }
}
