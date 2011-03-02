package net.azib.java.students.t105870.Lecture3;

public abstract class Pets extends Animal {

	private String name, owner;

	public Pets(String petName, int ageInYears, String ownerName){
		super(ageInYears);
		name = petName;
		owner = ownerName;
	}

	public void setName(String newName){
		name = newName;
	}

	public String getName(){
		return name;
	}

	public String getOwner(){
		return owner;
	}
}
