package net.azib.java.students.t092875.hw2;

import  net.azib.java.students.t092875.hw2.Animal;

/**
 * AnimalKingdom
 *
 * @author Mihhail
 */
public class AnimalKingdom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new AnimalKingdom().showAnimals();
	}
	
	public void showAnimals(){
		Animal[] animals = new Animal[5];
		animals[0] = new Dog("Sparky", 0, 30);
		animals[1] = new Wolf(2, 30);
		animals[2] = new Cat("Mr.Fluffy", 0, 30);
		animals[3] = new Cow("Betsy", 0, 30);
		animals[4] = new Cat("Mr.Fluffy", 0, 30,0);
		for (Animal animal : animals) {
			System.out.println(animal);
		}
	}

}
