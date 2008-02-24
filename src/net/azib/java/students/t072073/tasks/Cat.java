package net.azib.java.students.t072073.tasks;

/**
 * Cat
 *
 * @author t072073
 */
public class Cat extends Animal {

	public Cat() {
		super.setName("Unknown");
	}

	public Cat(String name) {
		super.setName(name);
	}
	/* (non-Javadoc)
	 * @see net.azib.java.students.t072073.tasks.Animal#animalClass()
	 */
	@Override
	String animalClass() {
		return "Cat";
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t072073.tasks.Animal#makeSound()
	 */
	@Override
	void makeSound() {
		System.out.println("Mjau!");

	}
	
	String coat(String color){
		String catCoat = getName() + " has a shiny " + color + " fur coat";
		return catCoat;
	}
	
}
