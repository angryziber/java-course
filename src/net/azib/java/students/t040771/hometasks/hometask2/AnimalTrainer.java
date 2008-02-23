package net.azib.java.students.t040771.hometasks.hometask2;

import java.util.Calendar;

/**
 * AnimalTrainer
 *
 * @author raido
 */
public class AnimalTrainer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Calendar rightNow = Calendar.getInstance();
		
		Animal animals[] = new Animal[5];
		
		animals[0] = new Turtle("Raphael", 20);
		animals[1] = new Turtle("Donatello", 20);
		animals[2] = new Turtle("Michelangelo", 20);
		animals[3] = new Turtle("Leonardo", 20);
		animals[4] = new Rabbit("Bugs Bunny", rightNow.get(Calendar.YEAR) - 1939);
		
		for(Animal a: animals) {
			System.out.println(a);
			a.makeSound();
			a.action();
		}
	}
}
