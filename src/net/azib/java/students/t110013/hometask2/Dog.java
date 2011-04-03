package net.azib.java.students.t110013.hometask2;

/**
 * @author Vadim
 */
public class Dog extends Pet {

	public Dog(String name, int age) {
		setName(name);
		setAge(age);
	}

	public String makeSound() {
		return "Woof!";
	}

	public String toString() {
		return "A " + (getAge() > 1 ? getAge() + " year" : "year") + " old dog named " + getName() + ": " + makeSound();
	}
}
