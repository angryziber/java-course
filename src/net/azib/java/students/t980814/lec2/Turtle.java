package net.azib.java.students.t980814.lec2;

/**
 * Turtle
 *
 * @author allan
 */
public class Turtle extends Animal {
	
	Turtle(String name, int age) {
		super(name, age, false);		
	}

	public void makeSound() {
		System.out.println("mmm");
	}
	
	public String toString() {
		return "Turtle " + name;
	}
}
