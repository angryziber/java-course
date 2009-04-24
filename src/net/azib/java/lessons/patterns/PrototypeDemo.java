package net.azib.java.lessons.patterns;

import net.azib.java.lessons.basic.Animal;
import net.azib.java.lessons.basic.Cat;
import net.azib.java.lessons.basic.Dog;

/**
 * PrototypeDemo
 *
 * @author anton
 */
public class PrototypeDemo {
	public static void main(String[] args) {
		copyAnimals(new Dog("MegaDog", 1));
		copyAnimals(new Cat("SomeCat", 2));
	}

	private static void copyAnimals(Animal animalPrototype) {
		for (int i = 0; i < 3; i++) {
			Animal newAnimal = animalPrototype.clone();
			System.out.println(newAnimal);
		}
	}
}
