package net.azib.java.students.t072054.hometask1;

/**
 * Animal
 * 
 * @author Roman
 */
abstract class Animal {
	private String name;
	private String age;

	void SetAge(String str) {
		age = str;
	}

	String getAge() {
		return age;
	}
	
	void SetName(String str) {
		name = str;
	}

	String getName() {
		return name;
	}

	abstract void makeSound();
}

class Dog extends Animal {
	void makeSound() {
		System.out.println("Woof!");
	}

}
