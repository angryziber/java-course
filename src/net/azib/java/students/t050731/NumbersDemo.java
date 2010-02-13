package net.azib.java.students.t050731;
public class NumbersDemo 
{	
	public void printNumbers()
	{		
		Fibonacci fib = new Fibonacci();
		Factorial fact = new Factorial();
		
		//Print fibonacci
		System.out.println(fib.calcFibonacci(100));
		
		//Print factorial
		System.out.println(fact.calcFactorial(100));
	}
}
