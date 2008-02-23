package net.azib.java.students.t040771.hometasks.hometask2;

/**
 * Turtle
 *
 * @author raido
 */
public class Turtle extends Animal {

	public Turtle(String name, int age) {
		super(name, "turtle", age, 4);
	}
	/* (non-Javadoc)
	 * @see net.azib.java.students.t040771.hometasks.hometask2.Animal#makeSound()
	 */
	@Override
	void makeSound() {
		System.out.println("...");
	}
	
	void action() {
		System.out.println("Ninja");
	}

}
