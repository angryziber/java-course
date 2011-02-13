package net.azib.java.students.t110013.hometask1;

/**
 * Created by IntelliJ IDEA.
 * User: Vadim
 * Date: 12.02.11
 * Time: 14:05
 */
public class NumbersDemo {
    public static void main(String[] args) {
        Factorial factorial100 = new Factorial(100);
        System.out.println(factorial100.getValue());

        Fibonacci fibonacci100 = new Fibonacci(100);
        System.out.println(fibonacci100.getValue());
    }
}
