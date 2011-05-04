package net.azib.java.students.t092877.lecture3;

public abstract class Pet extends Animal {

	private String name;
	private boolean hasOwner;

	public Pet(String title, int age, String sex, String family, String status, String name, boolean hasOwner) {
		super(title, age, sex, family, status);
		this.name = name;
		this.hasOwner = hasOwner;

	}

	public String getName() {
		return name;
	}

	public String hasAnOwner() {

		if (hasOwner)
			return "has an owner";
		else
			return "homeless";
	}

	public String toString() {

		return "Pet's name: " + getName() + " (" + getSex() + ") | type: "
        + getTitle() + " | age: " + getAge() + " year(s) old | status: "  + hasAnOwner();
	}
}

