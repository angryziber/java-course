package net.azib.java.students.t980814.lec2;

/**
 * Kangaroo
 *
 * @author allan
 */
public class Kangaroo extends Animal {

	Kangaroo(String name, int age) {
		super(name, age, true);		
	}

	public void makeSound() {
		System.out.println("wheee");
	}
	
	public String toString() {
		return "Kangaroo " + name;
	}
}
