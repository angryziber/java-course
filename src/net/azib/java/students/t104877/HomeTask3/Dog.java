package net.azib.java.students.t104877.HomeTask3;

public class Dog extends Pet{
	private boolean livesAtKennel;

	public Dog () {
		setName("Dog");
		setAge(1);
		setWeight(30);
		setFamily("Canidae");
		setFeeding("Omnivorous");
	}

	public void makeSound () {
		if (livesAtKennel == false) System.out.println("Dog " + getName() + ": Wof-woof");
		else System.out.println("Dog " + getRespondsTo() + " from its kennel: Wof-woof");
	}

	public boolean isLivesAtKennel() {
		return livesAtKennel;
	}

	public void setLivesAtKennel(boolean livesAtKennel) {
		this.livesAtKennel = livesAtKennel;
	}
}
