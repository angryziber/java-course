package net.azib.java.students.t050657;

/**
 * Dog
 *
 * @author t050657
 */
public class Dog {
	private int age;
	private String name = "unknown";
	
	public Dog(String name) {
		this.name = name;
	}
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void growUp() {
		this.age++;
	}
	
	public String toString() {
		return this.name + ", " + this.age + " years"; 
	}
}
