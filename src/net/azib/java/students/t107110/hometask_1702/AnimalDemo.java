package net.azib.java.students.t107110.hometask_1702;

public class AnimalDemo {
	public static void main(final String[] args) {
		for (Animal animal : new Animal[]{
				new Dog(3, 0.5, "Oscar", "fox terrier"),
				new Cat(15, 0.3, "Latte", 4),
				new Sheep(8, 1.1, "Dolly", 12),
				new Snake(5, 2.7, true)
		}) {
			System.out.println(animal);
		}
	}
}
