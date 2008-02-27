package net.azib.java.students.t654321.hometasks;

/**
 * Turtle
 *
 * @author karl
 */
public class Turtle extends Animal{

	/**
	 * @param name
	 * @param color
	 * @param age
	 */
	public Turtle(String name, String color, int age) {
		super(name, color, age);
	}

	@Override
	void fly() {
		System.out.println("Have you ever seen flying turtle");
	}

	@Override
	void jump() {
		System.out.println("I'm not a fles, I'm a turtle");
	}

	@Override
	void makeSound() {
		System.out.println("turtle making sound");
	}

	void swim(){
		System.out.println("Swimming to America");
	}
	
	public String toString(){
		return "I'm a turtle. My name is " + getName() + " and age is  " + getAge() + " years. I'm " + getColor();
	}
	
	
}
