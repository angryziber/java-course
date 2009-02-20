package net.azib.java.lessons.basic;

/**
 * Cat
 *
 * @author anton
 */
public class Cat extends Animal {

	public Cat(String name, int age) {
		super(name, age);
	}

	public void makeNoise() {
		System.out.println("Meow");
	}

}
