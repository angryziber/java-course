package net.azib.java.students.t103784;

import net.azib.java.students.t103784.HelloFactorial;
import org.junit.Test;
import java.math.BigInteger;
import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: Ott Madis Ozolit
 * Date: 6.04.11
 * Time: 22:22
 * To change this template use File | Settings | File Templates.
 */
public class HelloFactorialTest {
	 @Test
    public void testFactorial(){
        int x = 13;
        BigInteger[] factArray = {
                BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(2),
                BigInteger.valueOf(6), BigInteger.valueOf(24), BigInteger.valueOf(120),
                BigInteger.valueOf(720), BigInteger.valueOf(5040), BigInteger.valueOf(40320),
                BigInteger.valueOf(362880), BigInteger.valueOf(3628800), BigInteger.valueOf(39916800),
                BigInteger.valueOf(479001600)
        };
        for (int i = 0; i<x; i++){
            assertEquals("Function failed", HelloFactorial.thingamajig(i), factArray[i]);
            System.out.println("Test success for: "+ i + " factorial nr: "+ HelloFactorial.thingamajig(i));
        }
    }
}
