package net.azib.java.students.t103717.fibonachi;

import java.math.BigInteger;

/**
 * User: ruzard
 * Malyshev Konstantin 103717IAPB28
 * Date: 17.02.11
 */
public class LastPrev {
	public static BigInteger posl;
	public static BigInteger predposl;


	public static void setposl(BigInteger iposl) {
		posl = iposl;
	}

	public static BigInteger getPosl() {
		return posl;
	}

	public static void setpredposl(BigInteger ipred) {
		predposl = ipred;
	}

	public static BigInteger getpredposl() {
		return predposl;
	}

	public static BigInteger compute() {
		BigInteger a = getPosl();
		BigInteger b = getpredposl();
		BigInteger c = a.add(b);
		return (c);
	}

}
