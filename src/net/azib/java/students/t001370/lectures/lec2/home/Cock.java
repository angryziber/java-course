package net.azib.java.students.t001370.lectures.lec2.home;

/**
 * Cock
 *
 * @author maksim
 */
public class Cock extends Animal{
	Cock(String name){
		super(name);
	}
	Cock(String name, String birthDay){
		super(name, birthDay);
	}
	
	void makeSound(){
		System.out.println("\"Kukareku!\"");
	}
}
