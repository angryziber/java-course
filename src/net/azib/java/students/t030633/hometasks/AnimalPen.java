package net.azib.java.students.t030633.hometasks;

import java.util.Scanner;

/**
 * Collects animals into a pen.
 * 
 * @author t030633
 */
public class AnimalPen {

	private Animal[] animals;

	/**
	 * Constructs an animal collection of 3 animals by default.
	 */
	AnimalPen() {
		animals = new Animal[3];
	}

	/**
	 * Constructs an animal collection of n animals.
	 * 
	 * @param n
	 */
	AnimalPen(int n) {
		animals = new Animal[n];
	}

	public void catchAnimals() {

		int age;
		String name;

		System.out.println("We have caught " + animals.length + " animals!");
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < animals.length; i++) {

			System.out.print("Give it a name: ");
			name = scanner.next();
			System.out.print("Determine age: ");
			age = scanner.nextInt();
			System.out.print("What is it? 1) Dog 2) Cat 3) Horse ");

			switch (scanner.nextInt()) {
			case 1:
				animals[i] = new Dog(name, age);
				break;
			case 2:
				animals[i] = new Cat(name, age);
				break;
			case 3:
				animals[i] = new Horse(name, age);
				break;
			default:
				break;
			}

		}

	}

	public void callAnimals() {

		System.out.println("\nAnimals report in!");

		for (Animal a : animals) {
			if (a != null)
				System.out.println(a.toString());
		}

	}

	public static void main(String[] args) {
		
		AnimalPen pen = new AnimalPen();

		pen.catchAnimals();
		pen.callAnimals();

	}
}
