package net.azib.java.students.t104607;
// @author 104607 IASM

public abstract class Pet extends Animal{
	private String name;

	public abstract String makeSound();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
