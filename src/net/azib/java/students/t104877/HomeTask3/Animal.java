package net.azib.java.students.t104877.HomeTask3;

public abstract class Animal {

	private String name;

	private int age;
	private int weight;

	private String feeding;
	private String family;

	abstract void makeSound ();

	public void becomeOlder () {
		age++;
	}

	public void becomeOlder (int years) {
		age += years;
	}

	public void putOnWeight (int kg) {
		weight += kg;
	}

	public void lostWeight (int kg) {
		weight -= kg;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}


	public String getFeeding() {
		return feeding;
	}

	public String getFamily() {
		return family;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFeeding(String feeding) {
		this.feeding = feeding;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String toString() {
		return "Animal " + getName() + " (family " + getFamily() + ") is " + getFeeding() + " and weights " + getWeight() + " kg at age " + getAge() + " years";
	}
}
