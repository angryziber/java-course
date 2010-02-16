package net.azib.java.students.t100258;

public class NumbersDemo {

	static int n =100;
	
	public static void main(String[] args) {
		Fibonacci ofib= new Fibonacci();
		System.out.println("F"+n+" = "+ofib.calcFibonacci(n));
		
		Factorial ofac= new Factorial();
		System.out.println(n+"! = "+ofac.calcFactorial(n));
	}

}
