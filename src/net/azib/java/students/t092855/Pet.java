package net.azib.java.students.t092855;


public abstract class Pet extends Animal{
	private String name;

	public Pet(int age, String gender, String animalClass, String name) {
		super(age, gender, animalClass);
		this.name = name;
	}

	public abstract String makeSound();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return super.toString() + "Pet name: " + name + "; ";
	}
}
