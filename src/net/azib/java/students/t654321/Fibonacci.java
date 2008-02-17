package net.azib.java.students.t654321;

import java.math.BigDecimal;

public class Fibonacci {

	/**Finds Fibonacci series n-th element
	 * @param args
	 */
	
	private static BigDecimal calculateFibonacciElement(int whichElement){
		BigDecimal firstElement = new BigDecimal(0);
		//System.out.println("Fibonacci series element f(0) is: " + firstElement.toString());
		BigDecimal secondElement = new BigDecimal(1);
		//System.out.println("Fibonacci series element f(1) is: " + secondElement.toString());
		int i = 2;
		BigDecimal element = new BigDecimal(0);
		
		while(i < whichElement){
			element = firstElement.add(secondElement);
			firstElement = secondElement;
			secondElement = element;
			i++;
		}
		return element;
	}
	
	public static void main(String[] args) {
//		int whichElement = Integer.parseInt(args[0]);
		int whichElement = 100;
		BigDecimal element = calculateFibonacciElement(whichElement);
		System.out.println("Fibonacci series element f(" + whichElement + ") is: " + element.toString());
		}

}
