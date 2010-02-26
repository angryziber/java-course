package net.azib.java.students.t050724.animals;

/**
 * Pet
 *
 * @author xom
 */
public abstract class Pet extends Animal {

	/**
	 * @param age
	 * @param weight
	 */
	public Pet(int age, int weight) {
		super(age, weight);
	}

	protected String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
		
}
