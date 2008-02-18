package net.azib.java.students.t040771.lessons1;

/**
 * Dog
 *
 * @author t040771
 */
public class Dog {

	String name;
	
	public Dog() {
		name = "Dog";
	}
	
	public Dog(String name) {
		this.name = name; //sinine name on field
	}

	String getName() {
		final String newName = name;
		return newName;
	}

	public static void main(String[] args) {
		Dog a = new Dog("Pauka");
		Dog b = new Dog("Laika");
		Dog c = new Dog();
		
		//Integer i = 5; //Automaatne wrappimine
		//Integer int
		//Character char
		//i = Integer.parseInt("5");
		
		System.out.println("Dog a name is " + a.getName());//Ctrl+alt+up/down
		System.out.println("Dog b name is " + b.getName());
		System.out.println("Dog c name is " + c.getName());
	}
}
