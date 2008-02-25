package net.azib.java.students.t980814.lec2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Zoo
 *
 * @author allan
 */
public class Zoo {

	static Scanner scanner = new Scanner(System.in);

	static Date enterBirthday(String name) {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String enteredDate;
		Date returnDate = null;
		
		while (returnDate == null) {
			System.out.print("Enter " + name + "'s birthday (YYYY/MM/DD):");
			enteredDate = scanner.next();
			try {
				returnDate = df.parse(enteredDate);
			}
			catch(Exception e) {
				System.out.println("Use format YYYY/MM/DD!");
			}
		}
		return returnDate;
	}
	
	public static void main(String[] args) {
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
					e[i] = new Elephant(name, enterBirthday(name));
				break;
				
				case 2:
					System.out.print("Enter turtle's name: ");
					name = scanner.next();
					e[i] = new Turtle(name, enterBirthday(name));
				break;
				
				case 3:
					System.out.print("Enter kangaroo's name: ");
					name = scanner.next();
					e[i] = new Kangaroo(name, enterBirthday(name));
				break;	
			}
		}
		
		for (Animal currAnimal : e)
		{
			System.out.print(currAnimal + " sounds ");
			currAnimal.makeSound();
			System.out.println(currAnimal + (currAnimal.iCanJump() ? " can" : " cannot") + " jump." );
			currAnimal.getAge();
		}
	}
}
