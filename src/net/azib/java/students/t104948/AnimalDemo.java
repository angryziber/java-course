package net.azib.java.students.t104948;


public class AnimalDemo {

	public static void main(String[] args) {

		Cat newCat = new Cat();
		Dog newDog = new Dog();
		Lion newLion = new Lion();
		Frog newFrog = new Frog();

		Animal [] animalArray = {newCat, newDog, newLion, newFrog};

		for (Animal animal: animalArray)  {
			 animal.makeSound();
		}

	}

}
