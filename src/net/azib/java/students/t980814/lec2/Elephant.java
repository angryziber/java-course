package net.azib.java.students.t980814.lec2;

/**
 * Elephant
 *
 * @author allan
 */
public class Elephant extends Animal {

	public Elephant(String name, int age) {
		super(name, age, false);
	}
	
	public void makeSound() {
		System.out.println("Üüaaaarghh");
	}
	
	public String toString() {
		return "Elephant " + name;
	}
}
