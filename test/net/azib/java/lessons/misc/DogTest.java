package net.azib.java.lessons.misc;

import java.io.Serializable;

/**
 * DogTest
 *
 * @author anton
 */
public class DogTest {
	public static void main(String[] args) {
		Object dog1 = new Dog("Pitsu");
		Object dog2 = new Dog("Pitsu");
		System.out.println(dog1.equals(dog2));
		System.out.println(dog1 instanceof Serializable);
		System.out.println(dog1 instanceof Comparable);
	}
}
