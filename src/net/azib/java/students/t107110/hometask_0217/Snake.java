package net.azib.java.students.t107110.hometask_0217;

public class Snake extends Animal {
	private final boolean venomous;

	public Snake(final int ageInYears, final double sizeInMeters, final boolean venomous) {
		super(ageInYears, sizeInMeters);
		this.venomous = venomous;
	}

	@Override
	public void move() {
		System.out.println("creeping");
	}

	@Override
	public void eat() {
		System.out.println("eating eggs");
	}

	@Override
	public String toString() {
		return (venomous ? "" : "non-") + "venomous snake " + super.toString();
	}
}
