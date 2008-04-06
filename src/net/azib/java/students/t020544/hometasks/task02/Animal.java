package net.azib.java.students.t020544.hometasks.task02;

/**
 * Animal
 * 
 * @author Julija Kondratjeva
 */
public abstract class Animal {

	/**
	 * 
	 */
	public Animal(String name, int age) {
		this.age = age;
		this.name = name;
	}

	public abstract String makeSound();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + getName() + ", I am " + getAge() + " old. " + makeSound() + "!";
	}

	private String name;
	private int age;

}
