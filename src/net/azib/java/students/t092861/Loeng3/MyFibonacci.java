package net.azib.java.students.t092861.Loeng3;

/**
 * @author Human
 * 
 */
import java.math.BigInteger;

class MyFibonacci {
	BigInteger a = BigInteger.valueOf(1);
	BigInteger b = BigInteger.valueOf(1);
	BigInteger summ = BigInteger.valueOf(0);
	int i;

	void count() {
		for (i = 1; i <= 100; i++) {
			if (i <= 2)
				summ = BigInteger.valueOf(1);
			else
				summ = a.add(b);
			a = b;
			b = summ;
			if (i==100)
			System.out.println(summ);
		}
	}
}
