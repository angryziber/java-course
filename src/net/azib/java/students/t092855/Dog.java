package net.azib.java.students.t092855;

public class Dog extends Pet {

	public Dog(int age, String sex, String name) {
		super(age, sex, "mammal", name);
	}

	public String makeSound() {
		return "Auh, auh!";
	}

	public String toString() {
		return super.toString() + "Pet type: dog; ";
	}
}
