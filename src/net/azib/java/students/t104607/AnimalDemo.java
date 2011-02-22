package net.azib.java.students.t104607;
// @author 104607 IASM

import java.util.ArrayList;

public class AnimalDemo {
	public static void main(String[] args) {
		ArrayList<Animal> animals = new ArrayList<Animal>();

		animals.add(new Dog("Muki",1));
		animals.add(new Cat("Miisu",8));
		animals.add(new Frog());

		for (Animal animal:animals)  {
			System.out.println(animal.toString());
			if (animal instanceof Pet)
				System.out.println("\t\t" + ((Pet)animal).makeSound());
		}
	}
}
