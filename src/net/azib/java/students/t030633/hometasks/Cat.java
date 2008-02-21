package net.azib.java.students.t030633.hometasks;

/**
 * Extends Animal.
 * 
 * @author t030633
 */
public class Cat extends Animal {

	Cat() {
		species = "Cat";
	}
	
	Cat(String name, int age) {
		super(name, age);
		species = "Cat";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.azib.java.students.t030633.hometasks.Animal#makeSound()
	 */
	@Override
	public String makeSound() {
		return "Meow!";
	}

}
