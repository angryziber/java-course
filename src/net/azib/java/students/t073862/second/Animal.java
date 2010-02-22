package net.azib.java.students.t073862.second;

/**
 * Animal
 *
 * @author Pets
 */
public abstract class Animal {
	/**
	 * Animal age
	 */
	private int age;
	/**
	 * Animal age getter
	 * @return
	 */
	public int getAge() {
		return age;
	}
	/**
	 * Animal constructor
	 * @param age- age of the dog
	 */
	public Animal(int age) {
		this.age = age;
	}
	abstract void makesound();
	
	public String toString() {
		return "Class: " + this.getClass().toString() + " age: " + age;
		
	}
}
