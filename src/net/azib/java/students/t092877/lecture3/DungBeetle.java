package net.azib.java.students.t092877.lecture3;

public class DungBeetle extends Animal {

	private boolean dungBall;

	public DungBeetle(String title, int age, String sex, String family, String status,
			boolean dungBall) {
		super(title, age, sex, family, status);
		this.dungBall = dungBall;
	}

	public String isDungBallIncluded() {

		if (dungBall)
			return "with a dungball";
		else
			return "without dungball";
	}

	public String makeSound() {

		return "Smyrg, smyrg...";
	}

	public String toString() {
		return super.toString() + ". " + isDungBallIncluded();
	}
}
