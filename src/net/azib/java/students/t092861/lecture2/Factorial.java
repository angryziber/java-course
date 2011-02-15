package net.azib.java.students.t092861;
import java.math.BigInteger;

/**
 * @author Stanislav / 092861
 * 
 */
public class Factorial {

	/**
	 * @param n
	 *            - last index of the sequence
	 * @return the sum of Factorial sequence
	 */
	public BigInteger generate(int n) {
		BigInteger sum = BigInteger.ONE;
		if (n == 0) {
			return BigInteger.ONE;
		} else {
			int index = n+1;
			BigInteger[] array = new BigInteger[index];
			for (int i = 1; i < index; i++) {
				sum = sum.multiply(BigInteger.valueOf(i));
				array[i] = sum;
//				System.out.println("F" + i + "= " + sum);
			}
		}
		return sum;
	}
}
