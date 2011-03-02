package net.azib.java.students.t105870.Lecture3;

public abstract class Animal {
	private int ageInYears;

	public Animal(int ageInYears){
		this.ageInYears = ageInYears;
	}

	public int getAgeInYears(){
		return ageInYears;
	}

	public void makeSound(){
	}
}
