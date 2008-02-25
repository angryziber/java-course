package net.azib.java.students.t040750.homework.lesson2;


/**
 * Dog
 *
 * @author karpo
 */
public class Dog extends Animal {

	
	
	/**
	 * @param name
	 * @param age
	 * @param color
	 */
	public Dog(String name, String age, String color) {
		super(name, age, color);
	}

	@Override
	public void makeSound() {
		System.out.println("Woof");
	}

	public void wagTail() {
		System.out.println("Look, I'm wagging my tail!");
	}

	@Override
	public String toString() {
		return "I am a dog named " + getName();
	}
	
	
}
