package net.azib.java.students.t092855;


public abstract class Animal {
	private int age;
	private String gender;
	private String animalClass;

	public Animal(int age, String gender, String animalClass){
		this.age = age;
		this.gender = gender;
		this.animalClass = animalClass;
	}

	public int getAge() {
		return age;
	}

	public void becomeOlder() {
		age++;
	}

	public String getGender() {
		return gender;
	}

	public String getAnimalClass() {
		return animalClass;
	}

	public String toString() {
		return "Animal class: " + animalClass + "; Age: " + age + "; Gender: " + gender + "; ";
	}

}
