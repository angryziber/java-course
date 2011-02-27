package net.azib.java.students.t104923.hometask3;

public class Dog extends Pet {

	public Dog(String name)
	{
		super.name = name;
	    System.out.println("This dog's name is " + super.name);
	}

	public void makeSound() {
		System.out.println("Bark!");
	}
}
