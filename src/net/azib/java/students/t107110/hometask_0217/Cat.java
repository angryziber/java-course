package net.azib.java.students.t107110.hometask_0217;

public class Cat extends Pet {
	final int lives;

	public Cat(final int ageInYears, final double sizeInMeters, final String name, final int livesRemained) {
		super(ageInYears, sizeInMeters, name);
		lives = livesRemained;
	}

	@Override
	public void makeSound() {
		System.out.println("meowing");
	}

	@Override
	public void move() {
		System.out.println("slinking");
	}

	@Override
	public void eat() {
		System.out.println("eating fish");
	}

	@Override
	public String toString() {
		return "cat " + super.toString() + " still having " + lives + " lives";
	}
}
