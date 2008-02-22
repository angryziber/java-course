package net.azib.java.students.t001370.lectures.lec2.home;

/**
 * Cat
 *
 * @author maksim
 */
public class Cat extends Animal{
	Cat(String name){
		super(name);
	}
	
	Cat(String name, String birthDay){
		super(name, birthDay);
	}
	
	void makeSound(){
		System.out.println("\"Mijau!\"");
	}
}
