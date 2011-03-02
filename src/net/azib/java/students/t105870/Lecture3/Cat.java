package net.azib.java.students.t105870.Lecture3;

public class Cat extends Pets {

	private String nick;

	public Cat(){
		super("Nameless",0,"Nameless Owner");
		nick = "Nickless";
	}

	public  Cat(String name, String nickName, String owner, int ageInYears){
		super(name,ageInYears,owner);
		nick = nickName;
	}

	public void makeSound(){
		System.out.println("Meow!");
	}

	public String toString(){
		return "[Type: Cat(Animal, Pets)][Age: " + super.getAgeInYears() + " years]" +
				"[Name: " + super.getName() + "][Owner: " + super.getOwner() + "]" +
				"[Nick: " + nick + "]";
	}
}
