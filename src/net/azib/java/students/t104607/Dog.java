package net.azib.java.students.t104607;
// @author 104607 IASM

public class Dog extends Pet {
	public boolean haveBelt;

	Dog(String name,int age) {
		setName(name);
		setAge(age);
	}

	public String makeSound() {
		return "auhh-auhh";
	}

	public String toString() {
		return "dog with name " + getName();
	}
}
