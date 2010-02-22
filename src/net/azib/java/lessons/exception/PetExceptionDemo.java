package net.azib.java.lessons.exception;

import net.azib.java.lessons.basic.Dog;

/**
 * PetExceptionDemo
 *
 * @author anton
 */
public class PetExceptionDemo {
	public static void main(String[] args) {
		try {
			new Dog(null, 0);
		}
		catch (PetNameException e) {
			System.out.println(e.getClass() + " was caused by " + e.getCause());
		}
	}
}
