package net.azib.java.students.t092861.Loeng3;

/**
 * @author Stanislav
 *
 */
import java.math.BigInteger;

class MyFactorial {
	int i;
	BigInteger summ = BigInteger.valueOf(1);

	void count() {
		for (i = 1; i <= 100; i++) {
			summ = summ.multiply(BigInteger.valueOf(i));
			if (i==100)
			System.out.println(summ);
		}
	}
}