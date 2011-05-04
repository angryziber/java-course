package net.azib.java.students.t092877.lecture3;

public class Cat extends Pet {

	private String coat;

	public Cat(String title, int age, String sex, String family, String status, String name,
			   boolean hasOwner, String coat) {
		super(title, age, sex, family, status, name, hasOwner);
		this.coat = coat;

	}

	public String getCoat() {
		return coat;
	}

	public String makeSound() {
		return "mjau, mjau...";
	}

	public String toString() {

		return super.toString()+ " | coat: " + getCoat() + " | call: " + makeSound();
	}
}

