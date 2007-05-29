package net.azib.java.students.t030630;

import java.io.Serializable;

/**
 * DogTest
 *
 * @author Kasutaja
 */
public class DogTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Comparable object1 = new Dog("Rambo");
		Comparable object2 = new Dog("Rambo");
		System.out.println(object1.equals(object2) + "  " + (object1 instanceof Serializable));
	}
}
