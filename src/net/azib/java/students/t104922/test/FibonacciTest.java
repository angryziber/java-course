package net.azib.java.students.t104922.test;
import static org.junit.Assert.*;

import net.azib.java.students.t104922.Lesson2.Factorial;
import net.azib.java.students.t104922.Lesson2.Fibonacci;
import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigInteger;

public class FibonacciTest {
    @Test
    public void testFibonacci(){
        int x = 21;
        BigInteger[] factArray = {
                BigInteger.valueOf(0), BigInteger.valueOf(1), BigInteger.valueOf(1),
                BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(5),
                BigInteger.valueOf(8), BigInteger.valueOf(13), BigInteger.valueOf(21),
                BigInteger.valueOf(34), BigInteger.valueOf(55), BigInteger.valueOf(89),
                BigInteger.valueOf(144), BigInteger.valueOf(233), BigInteger.valueOf(377),
                BigInteger.valueOf(610), BigInteger.valueOf(987), BigInteger.valueOf(1597),
                BigInteger.valueOf(2584), BigInteger.valueOf(4181), BigInteger.valueOf(6765)
        };
        for (int i = 0; i<x; i++){
           assertEquals("fibonacci() failed!", Fibonacci.fibonacci(i), factArray[i]);
            System.out.println("Test passed for nr: "+ i + " fibonacci nr: "+ Fibonacci.fibonacci(i));
        }
    }
}
