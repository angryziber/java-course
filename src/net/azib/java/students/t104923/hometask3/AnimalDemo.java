package net.azib.java.students.t104923.hometask3;

public class AnimalDemo {
	public static void main(String[] args) {
		Cat cat1 = new Cat("Lucky", 1, 3, "orange");
		Cat cat2 = new Cat("Smokey", 5, 10, "grey");
		Sheep sheep1 = new Sheep ("Dolly", 3, 15, "white");
		Dog dog1 = new Dog ("Spike", 7, 10, "black");

		Animal[] animals = {cat1, cat2, sheep1, dog1};

		for (Animal animal : animals) {
			System.out.println(animal.toString());
		}
	}
}
