package net.azib.java.students.t072073.tasks;

/**
 * Zoo
 *
 * @author janika
 */
public class Zoo {
	public static void main(String[] args) {
		Animal [] zoo = new Animal[] {
		  new Sheep("Dolly", 1),
		  new Sheep("Molly", 5),
		  new Elephant("Dumbo", 5, 30),
		  new Elephant("Kornelius", 40, 100)
		};
		
		for(Animal a : zoo){
			a.makeSound();
			System.out.println(a);
		}
	}

}
