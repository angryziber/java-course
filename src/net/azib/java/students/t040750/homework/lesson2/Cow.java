package net.azib.java.students.t040750.homework.lesson2;


/**
 * Cow
 *
 * @author karpo
 */
public class Cow extends Animal {
	
	/**
	 * @param name
	 * @param age
	 * @param color
	 */
	public Cow(String name, byte age, String color) {
		super(name, age, color);
	}

	@Override
	public void makeSound() {
		System.out.println("Moo");
	}
	
	public void giveMilk() {
		System.out.println("I just gave milk!");
	}	
}
