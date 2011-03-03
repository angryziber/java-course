package net.azib.java.students.t104950;

/**
 * Created by IntelliJ IDEA.
 * User: Priit
 * Date: 17.02.11
 * Time: 16:17
 * To change this template use File | Settings | File Templates.
 */
public class NumbersDemo {
    public static void main(String[] args) {

    long r;
    Fibonacci fibonacci = new Fibonacci();
    r= fibonacci.Calculate(99);
    System.out.println(r);

    Factorial factorial =new Factorial();
        r=factorial.Calculate(100);
        System.out.println(r);
    }

}
