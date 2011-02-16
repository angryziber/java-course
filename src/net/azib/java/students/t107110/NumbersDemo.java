package net.azib.java.students.t107110;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.Format;

/**
 * Created by IntelliJ IDEA.
 * User: eddy
 * Date: 2011-02-16
 * Time: 10:58
 * To change this template use File | Settings | File Templates.
 */
public class NumbersDemo {
    static final Format format = new DecimalFormat("#,##0");

    public static void main(final String[] args) {
        final int N70 = 70;
        final int N100 = 100;

        long start;
        long stop;

//        start = System.nanoTime();
//        final long FF70 = new FastFibonacci(N70).getValue();
//        stop = System.nanoTime();
//        System.out.println("F(" + N70 + "): " + format.format(FF70) + " (" + (stop - start) + " ns)");

//        start = System.nanoTime();
//        final BigInteger F70 = new Fibonacci(N70).getValue();
//        stop = System.nanoTime();
//        System.out.println("F(" + N70 + "): " + format.format(F70) + " (" + (stop - start) + " ns)");

        //System.out.println("F(" + N100 + "): " + format.format(new FastFibonacci(N100).getValue()));

        start = System.nanoTime();
        final BigInteger F100 = new Fibonacci(N100).getValue();
        stop = System.nanoTime();
        System.out.println("F(" + N100 + "): " + format.format(F100) + " (" + (stop - start) + " ns)");
    }
}
