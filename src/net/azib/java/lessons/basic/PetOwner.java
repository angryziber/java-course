package net.azib.java.lessons.basic;

public class PetOwner {

	public static void main(String[] args) {
		Bulldog dog = new Bulldog("Sharky");
		System.out.println(dog.toString());

		System.out.println(new Bulldog("a") instanceof Animal);
		System.out.println(new Dog("a") instanceof Animal);
	}
}
