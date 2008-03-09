package net.azib.java.students.t654321.hometasks;

import java.math.BigInteger;

/**
 * Factorial
 *
 * @author t999902
 */
public class Factorial {

	/**
	 * @param whichElement - index of element of factorial. 
	 * @return 
	 */
	public BigInteger calculateFactorial(int whichElement) {
		int i = 0;
		BigInteger factorial = new BigInteger("1");
		
		if(whichElement < 0)
			return null;
		
		switch(whichElement){
		case 0:
			return BigInteger.ZERO;
		case 1:
			return BigInteger.ONE;
		default:
			while (i < whichElement){
				// Kas alati uus BigInteger objekt?
				BigInteger indx = new BigInteger(Integer.toString(i + 1));
				factorial = factorial.multiply(indx);
				i++;
			}
			return factorial;
		}
	}
}
