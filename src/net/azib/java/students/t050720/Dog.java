package net.azib.java.students.t050720;

/**
 * Dog
 *
 * @author Marek
 */
public class Dog extends Pet {
	
	Breed breed;

	void makeSound() {

		System.out.println("woof!");
	}

	public String toString()
	{
		return new String("Hi! I'm a dog!");
	}

}
