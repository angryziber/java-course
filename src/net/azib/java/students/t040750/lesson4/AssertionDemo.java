package net.azib.java.students.t040750.lesson4;

import net.azib.java.students.t040750.hometasks.lesson1.Fibonacci;

/**
 * AssertionDemo
 *
 * @author t040750
 */
public class AssertionDemo {
	public static void main(String[] args) {
		int i = 3;
		assert i == 5 : "Vale väärtus!";	//assertionid on vaikimisi välja lülitatud
											//VM arguments: -enableassertions või lihtsamalt -ea
		
		Fibonacci fibonacci = new Fibonacci();
		
		System.out.println(i);
	}
}
