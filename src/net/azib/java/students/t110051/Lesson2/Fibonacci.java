package net.azib.java.students.t110051.Lesson2;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Priit
 * Date: 16.02.11
 * Time: 12:58
 * To change this template use File | Settings | File Templates.
 */
public class Fibonacci {
    public static void Computation() {
        ArrayList<BigInteger> array = new ArrayList<BigInteger>();
        int i = 1;
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        array.add(i - 1, b);
        array.add(i, a);

        do {
            a = array.get(i);
            b = array.get(i - 1);
            a = a.add(b);
            array.add(i + 1, a);
            i++;
            System.out.println("Fibonacci number is: " + array.get(i));
        }
        while (array.size() <= 100);

    }
}
