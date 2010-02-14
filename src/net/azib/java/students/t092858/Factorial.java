package net.azib.java.students.t092858;


import java.math.BigInteger;

/**
 * Factorial
 *
 * @author qwert
 */
public class Factorial {
	static BigInteger calculate(int SequenceLenght){
	BigInteger factorial = new BigInteger("1");
	BigInteger count = new BigInteger("0");
	
	if (SequenceLenght < 0){
		return count;
	}
	for(int i = 0; i < SequenceLenght; i++){
		count = count.add(BigInteger.ONE);
		factorial = factorial.multiply(count);
	}
	return factorial;
	}
}
