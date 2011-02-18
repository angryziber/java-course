package net.azib.java.students.t110051.Lesson2;

import java.math.BigInteger;
import java.util.ArrayList;

public class Fibonacci {

	public static BigInteger Computation(int n) {

		ArrayList<BigInteger> array = new ArrayList<BigInteger>();
		int i = 1;
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1");
		array.add(i - 1, b);
		array.add(i, a);

		if (n <= 0) {
			throw new NumberFormatException();
		} else {
			do {
				a = array.get(i);
				b = array.get(i - 1);
				a = a.add(b);
				array.add(i + 1, a);
				i++;
			}
			while (i <= n);
			return array.get(i);
		}
	}
}
