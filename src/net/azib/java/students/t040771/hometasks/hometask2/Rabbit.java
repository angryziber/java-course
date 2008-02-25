package net.azib.java.students.t040771.hometasks.hometask2;

/**
 * Rabbit
 *
 * @author raido
 */
public class Rabbit extends Animal {

	public Rabbit(String name, int age) {
		super(name, "rabbit", age, 4);
	}
	/* (non-Javadoc)
	 * @see net.azib.java.students.t040771.hometasks.hometask2.Animal#makeSound()
	 */
	@Override
	void makeSound() {
		System.out.println("What's up, Doc?");
	}	
	
	@Override
	void action() {
		System.out.println("Run really fast");
	}
}
