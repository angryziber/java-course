package net.azib.java.students.t980814.lec4;

import net.azib.java.students.t980814.lec1.Fibonacci;

/**
 * TestingDemo
 *
 * @author dell
 */
public class TestingDemo {

	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci(5);
		
		// use -ea parameter to enable assertions
		assert "5".equals(fib.getResult().toString());
		
		if(!"5".equals(fib.getResult().toString()))
			throw new RuntimeException("failed");
		
		System.out.println(fib.getResult());
	}
	
}
