package net.azib.java.students.t073639.taskAnimal;

/**
 * @author t073639
 * 
 */
abstract class Animal {
	protected int age;

	public Animal(int age) {
		this.age = age;
	}

	abstract void makeSound();
}
