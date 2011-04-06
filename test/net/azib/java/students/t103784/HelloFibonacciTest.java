package net.azib.java.students.t103784;

import net.azib.java.students.t103784.HelloFibonacci;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: Ott Madis Ozolit
 * Date: 6.04.11
 * Time: 22:53
 * To change this template use File | Settings | File Templates.
 */
public class HelloFibonacciTest {
	@Test
    public void testFibonacci(){
	int x = 10;
        BigInteger[] factArray = {
				BigInteger.valueOf(0), BigInteger.valueOf(0), BigInteger.valueOf(1), BigInteger.valueOf(1),
                BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(5),
                BigInteger.valueOf(8), BigInteger.valueOf(13), BigInteger.valueOf(21),

        };
        for (int i = 0; i<x; i++){
            assertEquals("Function failed", HelloFibonacci.whatchamacallit(i), factArray[i]);
            System.out.println("Test success for: "+ i + " fibonacci nr: "+ HelloFibonacci.whatchamacallit(i));
        }
    }
}


