package net.azib.java.students.t980814.lec2;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Zoo
 *
 * @author allan
 */
public class Zoo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nofAnimals;
		
		System.out.print("Enter number of animals: ");
		nofAnimals = scanner.nextInt();
		
		Animal[] e = new Animal[nofAnimals];
	
		for (int i = 0; i < nofAnimals; i++) {
			String name;
			int selection;
			
			do {
				System.out.print("Is the " + (i+1) +". animal elephant (1), turtle (2), or kangaroo (3):");
				selection = scanner.nextInt();
			} while (selection < 1 || selection > 3);

			switch (selection)
			{
				case 1: 
					System.out.print("Enter elephant's name: ");
					name = scanner.next();
					e[i] = new Elephant(name, 42);
				break;
				
				case 2:
					System.out.print("Enter turtle's name: ");
					name = scanner.next();
					e[i] = new Turtle(name, 129);
				break;
				
				case 3:
					System.out.print("Enter kangaroo's name: ");
					name = scanner.next();
					e[i] = new Kangaroo(name, 12);
				break;	
			}
		}
		
		Calendar rightNow = Calendar.getInstance(); // või new Date();
		System.out.println(rightNow.getTime());
		
		
		
		for (Animal currAnimal : e)
		{
			System.out.print(currAnimal + " sounds ");
			currAnimal.makeSound();
			System.out.println(currAnimal + (currAnimal.iCanJump() ? " can" : " cannot") + " jump." );
		}
	}
}
