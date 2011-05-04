package net.azib.java.students.t092877.lecture3;

public class Dog extends Pet {

	private String breed;

	public Dog(String title, int age, String sex, String family, String status,
				String name, boolean hasOwner, String breed) {

		super(title, age, sex, family, status, name, hasOwner);
		this.breed = breed;
	}

	public String getBreed() {
		return breed;
	}

	public String makeSound() {
		return "woof, woof...";
	}

	public String toString() {

		return super.toString()+ " | breed: " + getBreed() + " | call: " + makeSound();
	}
}

