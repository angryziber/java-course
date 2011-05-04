package net.azib.java.students.t092877.lecture3;

public abstract class Animal {

	private String title;
	private int age;
	private String sex;
	private String family;
	private String status;

	public Animal(String title, int age, String sex, String family, String status) {

		this.title = title;
		this.age = age;
		this.sex = sex;
		this.family = family;
		this.status = status;

	}

	public String getTitle() {
		return title;
	}
	public int getAge() {
		return age;
	}

	public String getSex() {
		return sex;
	}

	public String getFamily() {
		return family;
	}

	public String getStatus() {
		return status;
	}

	public abstract String makeSound();

	public String toString() {

		return "Animal: " + getTitle() + " | family: " + getFamily() + " | status: "
		                  + getStatus() + " | animal call: " + makeSound();
	}
}

