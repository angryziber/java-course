package net.azib.java.students.t105870.Lecture3;

public class Parrot extends Pets {

	private int kmFly;

	public Parrot(){
		super("Nameless",0,"Unknown");
		kmFly = 0;
	}

	public Parrot(String name, String owner, int ageInYears, int kmFly){
		super(name,ageInYears,owner);
		this.kmFly = kmFly;
	}

	public void makeSound(){
		System.out.println("fiii-fiiii");
	}

	public String toString(){
		return "[Type: Parrot(Animal, Pets)][Age: " + super.getAgeInYears() + " years]" +
				"[Name: " + super.getName() + "][Owner: " + super.getOwner() + "]" +
				"[Have flight: " + kmFly + "]";
	}
}
