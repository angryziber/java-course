package net.azib.java.students.t050724.animals;

/**
 * AnimalsDemo
 *
 * @author xom
 */
public class AnimalsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AnimalsDemo demo = new AnimalsDemo();
		
		demo.stuffAnimals();

	}

	private void stuffAnimals() {
		
		//just to understand explicit constructors
		Dog indiana = new Dog(2, 35, "German Shepherd Dog");
		GuineaPig poochie = new GuineaPig(1, 2);
		Bear brownBear = new Bear(6, 150);
		
		Animal[] animals = {indiana, poochie, brownBear};
		
		for (Animal animal : animals) {
			print(animal);
		}
		
	}

	private void print(Animal animal) {
		System.out.println("Hello! I'm "+getType(animal)+". My age is "+animal.getAge()+" and I sound somtehing like this:");
		animal.makeSound();
	}

	private String getType(Animal animal) {
		return animal.getClass().getSimpleName().toLowerCase().toString();
	}
	
}
