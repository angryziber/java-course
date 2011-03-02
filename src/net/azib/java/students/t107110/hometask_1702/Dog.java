package net.azib.java.students.t107110.hometask_1702;

public class Dog extends Pet {
	private final String breed;

	public Dog(final int ageInYears, final double sizeInMeters, final String name, final String breed) {
		super(ageInYears, sizeInMeters, name);
		this.breed = breed;
	}

	@Override
	public void move() {
		System.out.println("walking");
	}

	@Override
	public void eat() {
		System.out.println("eating beef");
	}

	@Override
	public void makeSound() {
		System.out.println("barking");
	}

	@Override
	public String toString() {
		return breed + " dog " + super.toString();
	}
}
