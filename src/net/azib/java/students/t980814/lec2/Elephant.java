package net.azib.java.students.t980814.lec2;

import java.util.Date;

/**
 * Elephant
 *
 * @author allan
 */
public class Elephant extends Animal {

	protected String origin;
	
	public Elephant(String name, Date birthDay) {
		super(name, birthDay, false);
	}
	
	public void makeSound() {
		System.out.println("Üüaaaarghh");
	}
	
	//public String toString() {
	//	return "Elephant " + super.toString();
	//}
}
