package net.azib.java.students.t092855;


public abstract class Animal {
	private int age;
	private String sex;
	private String animalClass;

	public Animal(int age, String sex, String animalClass){
		this.age = age;
		this.sex = sex;
		this.animalClass = animalClass;
	}

	public int getAge() {
		return age;
	}

	public void becomeOlder() {
		age++;
	}

	public String getSex() {
		return sex;
	}

	public String getAnimalClass() {
		return animalClass;
	}

	public String toString() {
		return "Animal class: " + animalClass + "; Age: " + age + "; Sex: " + sex + "; ";
	}

}
