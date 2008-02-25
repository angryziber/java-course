package net.azib.java.students.t001370.lectures.lec2.home;


/**
 * Dog
 *
 * @author maksim
 */
public class Dog extends Animal{
	
	Dog(String name){
		super(name);
	}
	Dog(String name, String birthDay){
		super(name, birthDay);
	}
	
	void makeSound(){
		System.out.println("\"Gaf-Gaf!\"");
	}
	
	
}
