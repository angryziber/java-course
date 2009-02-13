package net.azib.java.lessons.basic;

/**
 * Dog
 *
 * @author anton
 */
public class Dog {
	private String name;
	private int age;
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Dog named " + name + " and aged " + age;
	}
}
