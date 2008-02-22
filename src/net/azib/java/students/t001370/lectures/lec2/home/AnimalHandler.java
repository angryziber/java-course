package net.azib.java.students.t001370.lectures.lec2.home;

/**
 * AnimalHandler
 *
 * @author maksim
 */
public class AnimalHandler {

	static Animal[] animalArray = new Animal[] {new Dog("Doggy", "22.02.2004"),
										 		new Cat("Catty", "23.12.1999"),
										 		new Cock("Cocky", "05.06.1990"),
										 		new Cow("Cowy")};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 0;

		System.out.println("Animals in array:");
		System.out.println("-----------------------------------");
		for (Animal animal: animalArray) {
			System.out.println(++i + " - " + animal);
			System.out.print(animal.getName() + " is making sound like: ");
			animal.makeSound();
			System.out.println("-----------------------------------");
		}
	}
}
