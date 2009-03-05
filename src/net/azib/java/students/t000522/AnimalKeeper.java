package net.azib.java.students.t000522;

import java.util.Date;

/**
 * AnimalKeeper
 *
 * @author jurrassic
 */
public class AnimalKeeper {

	public static void main(String[] args) {
		Date birthdate = new Date();
		birthdate.setTime(933312312312L);
		Date takenon = new Date();
		Animal[] animals = {new Dog("Zuchka", 10, new Date(), 1), 
							new Cat("Kisa", 2, birthdate, takenon),
							new Frog("Kit", 1, birthdate, 2)};

		for (Animal animal : animals) {
			System.out.println(animal);
		}
	}
}
