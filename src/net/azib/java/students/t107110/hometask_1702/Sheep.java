package net.azib.java.students.t107110.hometask_1702;

public class Sheep extends Pet {
	private final int wool;

	public Sheep(final int ageInYears, final double sizeInMeters, final String name, final int woolInKg) {
		super(ageInYears, sizeInMeters, name);
		wool = woolInKg;
	}

	@Override
	public void makeSound() {
		System.out.println("baaing");
	}

	@Override
	public void move() {
		System.out.println("running");
	}

	@Override
	public void eat() {
		System.out.println("eating grass");
	}

	@Override
	public String toString() {
		return "sheep " + super.toString() + " wearing " + wool + " kg of wool";
	}
}
