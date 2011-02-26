package net.azib.java.students.t104877.HomeTask3;

public class AnimalDemo {

	public static void main(String[] args) {
		Hedgehog hedgehog = new Hedgehog();
		Dog dog = new Dog();
		Sheep sheep = new Sheep();
		Tiger tiger = new Tiger();

		dog.setOwner("Jack");
		dog.setLivesAtKennel(true);
		dog.setRespondsTo("Brian");

		Animal animals[] = {hedgehog, dog, sheep, tiger};

		for (Animal animal : animals) {
			System.out.println(animal.toString());
			animal.makeSound();
		}
	}
}
