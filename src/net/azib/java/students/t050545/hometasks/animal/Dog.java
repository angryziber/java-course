package net.azib.java.students.t050545.hometasks.animal;


/**
 * Dog
 *
 * @author libricon
 */
public class Dog extends Animal {
	Dog(String name, int age){ 
		super(name, age);
	}

	public void makeSound() {
		System.out.println("Dog is barking !!!");
	}

	public void eat() {
		System.out.println("Dog eats dog's food");
	}
	
	@Override public String toString() {
		return "Dog's name is "+getName()+" and it's "+getAge();
	}
}