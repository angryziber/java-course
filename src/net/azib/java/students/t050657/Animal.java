package net.azib.java.students.t050657;

/**
 * Animal
 *
 * @author t050657
 */

public abstract class Animal {
	private int age;
	private String name = "unknown";
	
	public Animal(String name) {
		this.name = name;
	}
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	abstract public String getType();
	
	public int getAge() {
		return this.age;
	}
	
	public void growUp() {
		this.age++;
	}
	
	public String toString() {
		return "I am " + this.getType() + " " + this.name + ", " + this.age + " years"; 
	}
}
