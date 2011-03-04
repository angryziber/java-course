package net.azib.java.lessons.basic;

public class CloneDemo {
	public static void main(String[] args) {
		Animal animal = new Dog("Dolly");
		Animal reference = animal;
		Animal clone = animal.clone();

		System.out.println(animal == reference);
		System.out.println(animal == clone);
		System.out.println(animal.equals(clone));
		System.out.println(clone);
	}
}
