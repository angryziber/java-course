package net.azib.java.students.t092877.lecture3;

public class AnimalDemo {

	public static void main(String[] args) {

		Animal[] animals = new Animal[] {

				new Dog("Dog", 6, "male", "Canidae", "least concern", "Snipe", false, "Alaskan Malamute"),
				new Cat("Cat", 5, "female", "Felidae", "least concern", "Tessi", true, "longhair"),
				new DungBeetle("Dung beetle", 2, "male", "Scarabaeoidea", "least concern", true),
		};

		for (Animal animal : animals) {

			System.out.println(animal);
		}
	}
}
