package net.azib.java.students.t092855;

public class Cat extends Pet {

	public Cat(int age, String gender, String name) {
		super(age, gender, "mammal", name);
	}

	public String makeSound() {
		return "Mjau!";
	}

	public String toString() {
		return super.toString() + "Pet type: cat; ";
	}
}
