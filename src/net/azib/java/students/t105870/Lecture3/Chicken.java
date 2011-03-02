package net.azib.java.students.t105870.Lecture3;

public class Chicken extends Pets{

	private int eggsLaid;

	public Chicken(){
		super("Nameless",0,"Unknown");
		eggsLaid = 0;
	}

	public Chicken(String name, String owner, int ageInYears, int eggs){
		super(name,ageInYears,owner);
		eggsLaid = eggs;
	}

	public void makeSound(){
		System.out.println("buck buck");
	}

	public String toString(){
		return "[Type: Cat(Animal, Pets)][Age: " + super.getAgeInYears() + " years]" +
				"[Name: " + super.getName() + "][Owner: " + super.getOwner() + "]" +
				"[Eggs laid: " + eggsLaid + "]";
	}
}
