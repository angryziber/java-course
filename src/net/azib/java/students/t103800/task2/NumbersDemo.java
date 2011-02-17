package net.azib.java.students.t103800.task2;

/**
 * User: Jaan Aigro 103800
 * Date: 14.02.11
 * Time: 12:41
 */
public class NumbersDemo {

    public static void main(String[] args) {
        // index 99 = 100th number, because indexing starts from 0.
        System.out.println("Lets generate a factorial and a fibonacci number:");
        System.out.println("fibo(99) = " + Fibonacci.generate(99));
        System.out.println("print100thsNumber(99) = " + Factorial.generate(99));
    }

}
