package net.azib.java.students.t092855;

public class Alligator extends Animal {
	private int noOfTeeth;

	public Alligator(int age, String sex) {
		super(age, sex, "reptile");
	}

	public int getNoOfTeeth() {
		return noOfTeeth;
	}

	public void setNoOfTeeth(int noOfTeeth) {
		this.noOfTeeth = noOfTeeth;
	}

	public String toString() {
		switch (noOfTeeth) {
			case 0:
				return super.toString() + "Alligator with no teeth; ";

			case 1:
			    return super.toString() + "Alligator with " + noOfTeeth + " tooth; ";

			default:
				return super.toString() + "Alligator with " + noOfTeeth + " teeth; ";
		}
	}
}
