package net.azib.java.students.t104948;


public class Dog extends Pet {
	void getSomethingToEat() {}

	void makeSound(){
		System.out.println("Dog: Bark");
	}

	void belongToOwner(){
		System.out.println("Dog called " + super.getName() + " belongs to " + super.getOwner());
	}
	void bringABall(){}
	void chaseCats(){}
}
