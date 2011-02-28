package net.azib.java.students.t110051.Lesson3;

abstract class Animal {
	int age = 1;
	String name = "Nameless";
	char sex = 'm';

	public Animal() {
	}

	;

	public Animal(String name) {
		System.out.println("Name of the animal is: " + name);
	}

	public Animal (int age) {

	}

	abstract String makeSound();

}
