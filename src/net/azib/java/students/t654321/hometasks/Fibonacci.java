package net.azib.java.students.t654321.hometasks;

import java.math.BigInteger;

public class Fibonacci {

	/**Finds Fibonacci series n-th element
	 * @param args
	 */
	
	public BigInteger calculateFibonacciElement(int whichElement){
		BigInteger firstElement = new BigInteger("0");
		//System.out.println("Fibonacci series element f(0) is: " + firstElement.toString());
		BigInteger secondElement = new BigInteger("1");
		//System.out.println("Fibonacci series element f(1) is: " + secondElement.toString());
		int i = 1;
		BigInteger element = new BigInteger("0");
		
		if(whichElement < 0)
			return null;
		
		switch(whichElement){
			case 0:
				return BigInteger.ZERO;
			case 1:
				return BigInteger.ONE;
			default:
				while(i < whichElement){
				element = firstElement.add(secondElement);
				firstElement = secondElement;
				secondElement = element;
				i++;
				}
				return element;
		}
	}
	
/*	public static void main(String[] args) {
//		int whichElement = Integer.parseInt(args[0]);
		int whichElement = 29;
		BigInteger element = calculateFibonacciElement(whichElement);
		System.out.println("Fibonacci series element f(" + (whichElement) + ") is: " + element.toString());
		}
*/
}
