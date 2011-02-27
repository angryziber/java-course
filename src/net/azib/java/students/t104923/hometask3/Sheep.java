package net.azib.java.students.t104923.hometask3;

public class Sheep extends Pet {

	public Sheep(String name)
	{
		super.name = name;
	    System.out.println("This sheep's name is " + super.name);
	}

	public void makeSound() {
		System.out.println("Bleat!");
	}
}
