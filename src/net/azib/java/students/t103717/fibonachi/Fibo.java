package net.azib.java.students.t103717.fibonachi;

import java.math.BigInteger;

/**
 * User: ruzard
 * Malyshev Konstantin 103717IAPB28
 * Date: 17.02.11
 */
public class Fibo {


	static BigInteger Fnachi(int p) {
		switch (p) {
			case 1:
				LastPrev.setposl(BigInteger.ONE);
				LastPrev.setpredposl(BigInteger.ONE);
				return LastPrev.getPosl();
			case 2:
				LastPrev.setposl(BigInteger.ONE);
				return LastPrev.getPosl();
			default:
				break;
		}
		BigInteger chislo = LastPrev.compute();
		LastPrev.setpredposl(LastPrev.getPosl());
		LastPrev.setposl(chislo);
		return chislo;
	}

	public static void main(String[] args) {
		int i;
		for (i = 1; i <= 10000; i++) {
			System.out.print(Fnachi(i) + "\n\n");
		}

	}
}
