

package net.azib.java.students.t030682;

/**
 * fibonacci
 * 
 * @author t030682
 */
import java.math.BigInteger;

public class Fibonacci {

	public static void main(String[] args) {
		BigInteger previous = BigInteger.valueOf(-1);
		BigInteger result = BigInteger.valueOf(1);
		for (int i = 0; i <= 100; ++i) {
			BigInteger sum = result.add(previous);
			previous = result;
			result = sum;
		}
		System.out.println("100th element: " + result);
	}
}