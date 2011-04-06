package net.azib.java.students.t103784;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Ott Madis Ozolit
 * Date: 16.02.11
 * Time: 23:01
 * To change this template use File | Settings | File Templates.
 */
public class HelloFibonacci {

	public static void main(String[] args) {

		whatchamacallit(100);



	}
	public static BigInteger whatchamacallit(int a) {
		BigInteger fNum = new BigInteger("-1");
		BigInteger fNum2 = new BigInteger("1");
		BigInteger fSum = new BigInteger("0");

		for (int i = 0; i < a; i++) {
			fSum = fNum2.add(fNum);
			fNum = fNum2;
			fNum2 = fSum;
		}

		//System.out.println("Ossaraks: " + fSum);
		return fSum;
	}


}
