package net.azib.java.students.t110013.hometask2;

/**
 * @author Vadim
 */
public abstract class Pet extends Animal {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract String makeSound();
}
