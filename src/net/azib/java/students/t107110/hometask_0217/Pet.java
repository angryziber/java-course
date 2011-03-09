package net.azib.java.students.t107110.hometask_0217;

public abstract class Pet extends Animal {
	private final String name;

	public Pet(final int ageInYears, final double sizeInMeters, final String name) {
		super(ageInYears, sizeInMeters);
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public abstract void makeSound();

	@Override
	public String toString() {
		return "pet " + super.toString() + " named " + name;
	}
}
