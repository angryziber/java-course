package net.azib.java.students.t092855;

public class AnimalDemo {
	public static void main(String[] args) {

		Animal[] animals = new Animal[] {
			new Dog(0, "M", "Charlie"),
			new Cat(2, "F", "Leedi"),
			new Alligator(15, "M")
		};

		for (Animal animal : animals) {
			System.out.println(animal.toString());
			if (animal instanceof Pet) {
				System.out.println(((Pet) animal).makeSound());
			}
		}

	}
}
