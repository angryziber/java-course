package net.azib.java.students.t107110.hometask_0217;

public abstract class Animal {
	private final int age;
	private final double size;

	public Animal(final int ageInYears, final double sizeInMeters) {
		age = ageInYears;
		size = sizeInMeters;
	}

	public int getAge() {
		return age;
	}

	public double getSize() {
		return size;
	}

	abstract public void move();

	abstract public void eat();

	public String toString() {
		return "animal " + age + " year old " + size + " meters in size";
	}
}
