package net.azib.java.students.t104951.firstTry;
/**
 * Created by IntelliJ IDEA.
 * User: Lae
 * Date: 16.02.11
 * Time: 18:21
 * It's never easy..
 */
public class NumbersDemo {
    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
        Factorial facto = new Factorial();

        fibo.count(100);
        System.out.println(fibo.value);

        facto.count(100);
        System.out.println(facto.value);
    }
}
