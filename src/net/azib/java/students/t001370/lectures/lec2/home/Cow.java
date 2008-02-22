package net.azib.java.students.t001370.lectures.lec2.home;

/**
 * Cow
 *
 * @author maksim
 */
public class Cow extends Animal{
	
	Cow(String name){
		super(name);
	}
	Cow(String name, String birthDay){
		super(name, birthDay);
	}

	void makeSound(){
		System.out.println("\"Muuuuu!\"");
	}
}
