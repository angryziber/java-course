package net.azib.java.students.t104540.hometask2;

import java.math.BigInteger;

/**
 * Factorial class
 * <h1>test</h1>
 *
 * @author Hannes
 * @version 1
 * @see NumbersDemo
 *
 */
public class Factorial {

	/**
	 * gets factorial of parameter
	 * @param integer index
	 * @since version 123
	 * @return factorial
	 */
	public BigInteger getFactorialOf(int integer){
        BigInteger fact = new BigInteger("1");
        BigInteger counter = new BigInteger("1");


		/**
		 * sdsd
		 * sdsd
		 */



        while(counter.intValue()<integer){
            fact = fact.multiply(counter);
            counter = counter.add(BigInteger.ONE);
        }
        return fact;
    }
}
