package net.azib.java.students.t105870.Lecture3;

public class Dog extends Pets {


	public Dog(){
		super("Nameless",0,"Nameless Owner");
	}

	public Dog(String name, String owner, int ageInYears){
		super(name,ageInYears,owner);
	}

	public void makeSound(){
		System.out.println("Woof!");
	}

	public String toString(){
		return "[Type: Dog(Animal, Pets)][Age: " + super.getAgeInYears() + " years]" +
				"[Name: " + super.getName() + "][Owner: " + super.getOwner() + "]";
	}
}
