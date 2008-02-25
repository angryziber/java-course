package net.azib.java.students.t030633.hometasks;

/**
 * Extends Animal.
 * 
 * @author t030633
 */
public class Horse extends Animal {

	Horse() {
	}

	Horse(String name, int age) {
		super(name, age);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.azib.java.students.t030633.hometasks.Animal#makeSound()
	 */
	@Override
	protected String makeSound() {
		return "Neigh!";
	}

}
