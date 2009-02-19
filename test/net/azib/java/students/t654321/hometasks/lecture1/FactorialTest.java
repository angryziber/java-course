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
public class FactorialTest {

    public FactorialTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        int factorialNumber = -1;
        BigInteger referenceValue = new BigInteger("-1");
        BigInteger actualValue = Factorial.factorialCalculator(factorialNumber);
        assertEquals(referenceValue, actualValue);
    }

    @Test
    public void testFactorialOfZero() {
        int factorialNumber = 0;
        BigInteger referenceValue = BigInteger.ONE;
        BigInteger actualValue = Factorial.factorialCalculator(factorialNumber);
        assertEquals(referenceValue, actualValue);
    }

    @Test
    public void testFactorialOfOne() {
        int factorialNumber = 1;
        BigInteger referenceValue = BigInteger.ONE;
        BigInteger actualValue = Factorial.factorialCalculator(factorialNumber);
        assertEquals(referenceValue, actualValue);
    }

    @Test
    public void testFactorialCalculator() {
        int factorialNumber = 20;
        BigInteger referenceValue = new BigInteger("2432902008176640000");
        BigInteger actualValue = Factorial.factorialCalculator(factorialNumber);
        assertEquals(referenceValue, actualValue);
    }
}