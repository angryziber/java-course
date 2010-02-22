package net.azib.java.students.t073862.second;

/**
 * Pet
 *
 * @author Pets
 */
public abstract class Pet extends Animal {
	/**
	 * Pets' name
	 */
	private String name;
	/**
	 * Pets' name getter
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * Constructor for pet
	 * @param age - of the pet
	 * @param name - of the pet
	 */
	public Pet(int age, String name) {
		super(age);
		this.name = name;
	}
}
