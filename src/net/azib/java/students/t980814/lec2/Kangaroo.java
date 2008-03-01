package net.azib.java.students.t980814.lec2;

import java.util.Date;

/**
 * Kangaroo
 *
 * @author allan
 */
public class Kangaroo extends Animal {

	Kangaroo(String name, Date birthDay) {
		super(name, birthDay, true);		
	}

	public void makeSound() {
		System.out.println("wheee");
	}
	
	//public String toString() {
	//	return "Kangaroo " + super.toString();
	//}
}
