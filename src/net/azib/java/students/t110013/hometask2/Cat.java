package net.azib.java.students.t110013.hometask2;

/**
 * @author Vadim
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
