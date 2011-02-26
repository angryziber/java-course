package net.azib.java.students.t104877.HomeTask3;

public class Hedgehog extends Animal {

	private int apples;

	public Hedgehog() {
		setName("Hedgehog");
		setAge(1);
		setWeight(1);
		setFeeding("Omnivorous");
		setFamily("Erinaceidae");
		apples = 1;
	}

	void makeSound () {
		System.out.println("Hedgehog: khhhhh");
	}

	public int getApples() {
		return apples;
	}

	public void foundApple() {
		System.out.println("Hedgehog: hrju-hrju");
		apples++;
	}

	public void lostApple() {
		System.out.println("Hedgehog: x( khhhh");
		apples--;
	}

	public String toString() {
		return super.toString() + "\nHedgehog has " + getApples() + " apples";
	}
}