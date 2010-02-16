package net.azib.java.students.t073639.tasks;

import java.math.BigInteger;

/**
 * @author t073639
 * @version 2
 * @since Tuesday, 16 February 2010
 */
public class Factorial {
	BigInteger calculateNumber(int number) {
		BigInteger previous = BigInteger.ONE;
		BigInteger current = BigInteger.ONE;
		while (previous.intValue() <= number) {
			current = previous.multiply(current);
			previous = previous.add(BigInteger.ONE);
		}
		return current;
	}
}
