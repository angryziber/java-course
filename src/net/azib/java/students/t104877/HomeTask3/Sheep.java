package net.azib.java.students.t104877.HomeTask3;

public class Sheep extends Animal{

	private boolean hasHair;

	public Sheep () {
		setName("Sheep");
		setAge(1);
		setWeight(50);
		setFamily("Bovidae");
		setFeeding("Herbivore");
		hasHair = true;
	}

	public void makeSound () {
		System.out.println("Sheep: Mee-ee-ee");
	}

	public void shaveSheep () {
		System.out.println("Sheep: Mee-ee-ee");
		hasHair = false;
		lostWeight(2);
	}

	public String toString () {
		if (hasHair == true) return super.toString() + "\nIt has hair";
		else return super.toString() + "\nIt doesn't have hair";
	}
}
