package net.azib.java.students.t104607;
// @author 104607 IASM

public class Cat extends Pet{
	public boolean isBlack;

	Cat(String name,int age) {
		setName(name);
		setAge(age);
	}

	public String makeSound() {
		return "mjauu-mjauuuuuu";
	}

	public String toString() {
		return "cat with name " + getName();
	}

}
