package net.azib.java.students.t110013.hometask2;

/**
 * Created by IntelliJ IDEA.
 * User: Vadim
 * Date: 24.02.11
 * Time: 15:25
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
