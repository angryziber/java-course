package net.azib.java.students.t092855;

public class Dog extends Pet {

	public Dog(int age, String gender, String name) {
		super(age, gender, "mammal", name);
	}

	public String makeSound() {
		return "Auh, auh!";
	}

	public String toString() {
		return super.toString() + "Pet type: dog; ";
	}
}
