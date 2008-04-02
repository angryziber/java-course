package net.azib.java.students.t030633.hometasks.animals;

/**
 * Extends Animal.
 * 
 * @author t030633
 */
public class Dog extends Animal {

	Dog() {
	}

	Dog(String name, int age) {
		super(name, age);
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
