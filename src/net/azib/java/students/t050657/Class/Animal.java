package net.azib.java.students.t050657.Class;

/**
 * Animal
 *
 * @author t050657
 */

public abstract class Animal implements IAnimal {
	private int age;
	private String name = "unknown";
	
	public Animal(String name) {
		this.name = name;
	}
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	/* (non-Javadoc)
	 * @see net.azib.java.students.t050657.IAnimal#getName()
	 */
	public String getName() {
		return this.name;
	}
	
	abstract public String getType();
	
	/* (non-Javadoc)
	 * @see net.azib.java.students.t050657.IAnimal#getAge()
	 */
	public int getAge() {
		return this.age;
	}
	
	/* (non-Javadoc)
	 * @see net.azib.java.students.t050657.IAnimal#growUp()
	 */
	public void growUp() {
		this.age++;
	}
	
	public String toString() {
		return "I am " + this.getType() + " " + this.name + ", " + this.age + " years"; 
	}
}
