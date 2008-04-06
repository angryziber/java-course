package net.azib.java.students.t020544.hometasks.task02;

/**
 * AnimalsArray
 * 
 * @author Julija Kondratjeva
 */
public class AnimalsArray {

	public void displayAnimals() {
		for (Animal a : new Animal[] { new Dog("Doggy", 3, "John"),new Dog("Big dog", 7, "John"), new Cat("Kitty", 2, "black") }) {
			System.out.println(a);
		}

	}
	
	public static void main(String[] args) {
		AnimalsArray aa= new AnimalsArray();
		aa.displayAnimals();
	}

}
