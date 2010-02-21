package net.azib.java.students.t073639.taskFactFibo;

import java.math.BigInteger;

/**
 * @author t073639
 * @version 2
 * @since Tuesday, 16 February 2010
 */
public class Fibonacci {
	BigInteger calculateNumber(int number) {
		BigInteger previous = BigInteger.ZERO;
		BigInteger current = BigInteger.ONE;
		BigInteger next = BigInteger.ONE;
		int i = 0;
		if (number <= 0) {
			return BigInteger.ZERO;
		}
		else {
			while (i < number - 1) {
				next = previous.add(current);
				previous = current;
				current = next;
				i++;
			}
			return next;
		}
	}
}
