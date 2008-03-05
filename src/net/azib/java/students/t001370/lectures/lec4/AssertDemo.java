package net.azib.java.students.t001370.lectures.lec4;

import net.azib.java.students.t001370.lectures.lec1.Fibonacci;

/**
 * AssertDemo
 *
 * @author maksim
 */
public class AssertDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*int i = 3;
		assert i == 5 : "i is not 5 anymore";
		System.out.println(i);*/
		
		Fibonacci fib = new Fibonacci();
		System.out.println(fib.calc(10));
		
		assert "1".equals(fib.calc(1)): "jop";
		assert "2".equals(fib.calc(2)) : "bla-bla";
		
		if (!"1".equals(fib.calc(10))) {
			throw new RuntimeException("failed!!!");
		}
		
	}

}
