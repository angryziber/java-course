package net.azib.java.students.t104948;

public class Cat extends Pet {

	void getSomethingToEat() {}

	void makeSound(){
		System.out.println("Cat: Meow");
	}
	void belongToOwner(){
		System.out.println("Cat called " + super.getName() + " belongs to " + super.getOwner());
	}
	void catchMice(){}
	void sharpenClaws(){}


}
