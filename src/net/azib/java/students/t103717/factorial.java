package net.azib.java.students.t103717;

import java.math.BigInteger;

/**
 * User: ruzard
 * Malyshev Konstantin 103717IAPB28
 * Date: 17.02.11
 */
public class factorial {
	public static void main(String[] args) {
		int i;
		BigInteger chislo, summ;
		chislo = BigInteger.ZERO;
		summ = BigInteger.ONE;
		for (i = 1; i <= 100; i++) {
			if (i == 1) {
				chislo = BigInteger.ONE;
			}
			summ.multiply(chislo);
			chislo.add(BigInteger.ONE);
		}
		System.out.print(summ);
	}
}
