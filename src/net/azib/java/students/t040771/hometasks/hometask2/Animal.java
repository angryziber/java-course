package net.azib.java.students.t040771.hometasks.hometask2;

/**
 * Animal
 *
 * @author raido
 */
public abstract class Animal {

	protected String name;
	protected String species;
	protected int age;
	protected int legs;
	
	public Animal(String name, String species, int age, int legs) {
		this.name = name;
		this.species = species;
		this.age = age;
		this.legs = legs;
	}
	
	public String toString() {
		return "I am a " + species + ", my name is " + name 
				+ " and I'm " + age + " years old, " + species + "s have " + legs + " legs.";
	}
	
	abstract void makeSound();
	
	abstract void action();
	
}
