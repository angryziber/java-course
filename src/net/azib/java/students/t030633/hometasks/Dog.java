package net.azib.java.students.t030633.hometasks;

/**
 * Extends Animal.
 * 
 * @author t030633
 */
public class Dog extends Animal {

	Dog() {
		species = "Dog";
	}
	
	Dog(String name, int age) {
		super(name, age);
		species = "Dog";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.azib.java.students.t030633.hometasks.Animal#makeSound()
	 */
	@Override
	public String makeSound() {
		return "Woof!";
	}
}
