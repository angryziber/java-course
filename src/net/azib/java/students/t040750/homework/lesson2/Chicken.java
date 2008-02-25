package net.azib.java.students.t040750.homework.lesson2;


/**
 * Cat
 *
 * @author karpo
 */
public class Chicken extends Animal {

	/**
	 * @param name
	 * @param age
	 * @param color
	 */
	public Chicken(String name, String age, String color) {
		super(name, age, color);
	}

	@Override
	public void makeSound() {
		System.out.println("Tok Tok");
	}
	
	public void layEgg() {
		System.out.println("I just layed an egg!");
	}

	@Override
	public String toString() {
		return "I am a chicken and my feathers are " + getColor();
	}
}
