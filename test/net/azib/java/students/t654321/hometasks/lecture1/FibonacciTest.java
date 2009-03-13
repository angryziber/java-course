/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture1;

import java.math.BigInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karl
 */
public class FibonacciTest {

    @Test
    public void testfibonacciSeriesCalculatorInvalidinput() {
        int numberOfElement = -1;
        BigInteger expResult = new BigInteger("-1");
        BigInteger result = Fibonacci.fibonacciSeriesCalculator(numberOfElement);
        assertEquals(expResult, result);
    }

    @Test
    public void testfibonacciSeriesZerothElement() {
        int numberOfElement = 0;
        BigInteger expResult = new BigInteger("0");
        BigInteger result = Fibonacci.fibonacciSeriesCalculator(numberOfElement);
        assertEquals(expResult, result);
    }

    @Test
    public void testfibonacciSeriesFirstElement() {
        int numberOfElement = 1;
        BigInteger expResult = new BigInteger("1");
        BigInteger result = Fibonacci.fibonacciSeriesCalculator(numberOfElement);
        assertEquals(expResult, result);
    }

    @Test
    public void testCalculateFibonacciElement() {
        int numberOfElement = 100;
        BigInteger expResult = new BigInteger("218922995834555169026");
        BigInteger result = Fibonacci.fibonacciSeriesCalculator(numberOfElement);
        assertEquals(expResult, result);
    }
}