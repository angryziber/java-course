package net.azib.java.students.t104887.Lecture2;

import java.io.OutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 20.02.11
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
public class NumbersDemo
{
	public static void main(String[] args)
	{
		MathSequence fibonacci = new Fibonacci(100);
		MathSequence factorial = new Factorial(100);

		System.out.println("Fibonacci numbers: " + fibonacci.getValues());
		System.out.println("Factorial numbers: " + factorial.getValues());
	}
}
