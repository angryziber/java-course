package net.azib.java.students.t110051.Lesson2;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Priit
 * Date: 16.02.11
 * Time: 14:04
 * To change this template use File | Settings | File Templates.
 */
public class Factorial {
    public static void main(String[] args) {
        ArrayList<BigInteger> array = new ArrayList<BigInteger>();
        int index = 0;
        int counter = 1;
        BigInteger sum = new BigInteger("0");
        array.add(index, sum);

        do {
            if (array.size() == 1) {
                index = array.size();
                System.out.println("Factorial of 0 is 1");
                sum = BigInteger.ONE;
                array.add(index, sum);
            } else {
                index = array.size();

                for (; index > counter; counter++) {
                    sum = sum.multiply(array.get(counter));
                }
                counter = 1;
                System.out.println("Factorial of " + array.get(index - 1) + " is " + sum);

                sum = array.get(index - 1);
                sum = sum.add(BigInteger.ONE);
                array.add(index, sum);
                sum = BigInteger.ONE;

            }
        }
        while (array.size() <= 100);
    }
}