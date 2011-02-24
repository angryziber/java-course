package net.azib.java.students.t110013.hometask2;

/**
 * Created by IntelliJ IDEA.
 * User: Vadim
 * Date: 24.02.11
 * Time: 14:43
 */
public class Cat extends Pet {
	public Cat(String name, int age) {
		setName(name);
		setAge(age);
	}

	public String makeSound() {
		return "Meow!";
	}

	public String makePurr() {
		return "Purr, Purr, Purr!";
	}

	public String toString() {
		return "A " + (getAge() > 1 ? getAge() + " years" : "year") + " old cat named " + getName() + ": " + makePurr();
	}
}
