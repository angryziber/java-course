package net.azib.java.students.t030682.animal;

/**
 * Animal
 *
 * @author Administrator
 */
public abstract class Animal {
	String name;
	private int age;
	
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString()
	{
		return getClass().getSimpleName() + " named " + name + " aged " + age;
	}
	
	public abstract void makeSound();
	public abstract void makeThing();
}
