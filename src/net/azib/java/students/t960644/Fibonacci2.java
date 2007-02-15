package net.azib.java.students.t960644;

import java.math.BigInteger;

/**
 * Fibonacci2
 *
 * @author Lembit
 */
public class Fibonacci2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger i1 = new BigInteger("0");
		BigInteger i2 = new BigInteger("1");
		for (int i=2;i<100;i++){
			if (i1.compareTo(i2)<0){
				i1=i1.add(i2); 
			}
			else{
				i2=i2.add(i1);
			}
		}
		if (i1.compareTo(i2)<0)
			System.out.println(i2); 
		else 
			System.out.println(i1);
	}

}
