package net.azib.java.students.t110013.hometask2;

/**
 * Created by IntelliJ IDEA.
 * User: Vadim
 * Date: 24.02.11
 * Time: 15:03
 * To change this template use File | Settings | File Templates.
 */
public class AnimalDemo {
	public static void main(String[] args) {
		Cat kitty = new Cat("Kitty", 1);
		Dog buddy = new Dog("Buddy", 3);
		Tiger tiger = new Tiger(2);
		Zebra zebra = new Zebra(1);

		Animal[] animals = {kitty, buddy, tiger, zebra};

		for (Animal animal : animals) {
			System.out.println(animal.toString());
		}
	}
}
