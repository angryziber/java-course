package net.azib.java.students.t980814.lec2;

/**
 * Animal
 *
 * @author allan
 */
public abstract class Animal {

	protected String name;
	protected int age;
	protected boolean canJump;
	
	Animal() {
		this.name = "Unknown";
		this.age = 0;
		this.canJump = false;
	}
	
	Animal(String name, int age, boolean canJump) {
		this.name = name;
		this.age = age;
		this.canJump = canJump;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public boolean iCanJump() {
		return canJump;
	}

	abstract void makeSound();
}
