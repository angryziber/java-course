package net.azib.java.students.t074918;

/**
 * Dog world dogs descriptions
 *
 * @author Mart Mangus
 */
public class Dog {

	private String name;
	private int age = 2;
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Dog " + name + " is " + age + " year(s) old.";
	}
	
}
