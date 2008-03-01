package net.azib.java.students.t980814.lec2;

import java.util.Date;

/**
 * Turtle
 *
 * @author allan
 */
public class Turtle extends Animal {
	
	Turtle(String name, Date birthDay) {
		super(name, birthDay, false);		
	}

	public void makeSound() {
		System.out.println("mmm");
	}
	
	//public String toString() {
	//	return "Turtle " + super.toString();
	//}
}
