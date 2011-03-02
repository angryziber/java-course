package net.azib.java.students.t104607;
// @author 104607 IASM

public class AnimalDemo {
	public static void main(String[] args) {
		Animal[] animals = {
				new Dog("Muki",1),
				new Cat("Miisu",8),
				new Frog()
		};

		for (Animal animal:animals)  {
			System.out.println(animal.toString());
			if (animal instanceof Pet)
				System.out.println("\t\t" + ((Pet)animal).makeSound());
		}
	}
}
