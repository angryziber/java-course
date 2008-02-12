package net.azib.java.students.t980814;

import java.math.BigInteger;

/**
 * Fibonacci
 *
 * @author allan
 */
public class Fibonacci {

	BigInteger fibonacciNumber;
	BigInteger prevNumber;
	int fibonacciCount;
	
	Fibonacci(int n) {
		reCalculate(n);
	}
	
	public void reCalculate(int n) {
		BigInteger nextPrevNumber = new BigInteger("1");
		prevNumber = BigInteger.ZERO;
		
		fibonacciNumber = prevNumber;
		fibonacciCount = n;
		for (int count = 0; count <= n; count++) {
			fibonacciNumber = fibonacciNumber.add(prevNumber);
			prevNumber = nextPrevNumber;
			nextPrevNumber = fibonacciNumber;
			// System.out.println("Result=" + fibonacciNumber + ", prev=" + prevNumber + ", nextPrev=" + nextPrevNumber);
		}
	}
	
	public void calcNext() {
		BigInteger nextPrevNumber = fibonacciNumber;
		fibonacciNumber = fibonacciNumber.add(prevNumber);
		prevNumber = nextPrevNumber;
		fibonacciCount++;
	}
	
	public void calcPrev() {
		if (fibonacciCount > 0) {
			BigInteger prevPrevNumber = fibonacciNumber.subtract(prevNumber);
			fibonacciNumber = prevNumber;
			prevNumber = prevPrevNumber;
			fibonacciCount--;
		}
	}
	
	public BigInteger getResult() {
		return fibonacciNumber;
	}
	
	public int getCounter() {
		return fibonacciCount;
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci(0);
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
		f.reCalculate(10);
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
		f.calcNext();
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
		f.calcPrev();
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
		f.calcPrev();
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
		f.calcPrev();
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
		f.calcPrev();
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
		f.calcPrev();
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
		f.calcPrev();
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
		f.calcPrev();
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
		f.calcPrev();
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
		f.calcPrev();
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
		f.calcPrev();
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
		f.calcPrev();
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
		f.calcPrev();
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
		f.reCalculate(100);
		System.out.println("F(" + f.getCounter() + ")=" + f.getResult());
	}
}
