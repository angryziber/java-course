package net.azib.java.lessons.basic;

/**
 * Animal
 *
 * @author anton
 */
public abstract class Animal {
	private String name;
	private byte age;

	public Animal(String name) {
		this.name  = name;
	}

	public Animal(String name, byte age) {
		this.name = name;
		this.age = age;
	}	

	public String getName() {
		return name;
	}
	
	public void growUp() {
		age++;
	}
	
	public byte getAge() {
		return age;
	}
	
	public abstract void makeSound();

	@Override
	public String toString() {
		return "Animal named " + getName();
	}
}
