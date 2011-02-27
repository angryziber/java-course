package net.azib.java.students.t104923.hometask3;

public class Cat extends Pet {

	public Cat(String name)
	{
		super.name = name;
		System.out.println("This cat's name is " + super.name);
	}

	public void makeSound() {
		System.out.println("Meow!");
	}
}
