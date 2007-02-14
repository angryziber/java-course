package net.azib.java.students.t030675;

import java.io.Serializable;

public class DogTest{
	public static void main(String[] args) {
		Object dog1 = new Dog("Barbos");
		Object dog2 = new Dog("Barbos");
		System.out.println(dog1.equals(dog2));
		System.out.println(dog1 instanceof Serializable);
		System.out.println(dog1 instanceof Comparable);
	}
}