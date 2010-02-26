package net.azib.java.students.t050724.animals;

/**
 * Dog
 *
 * @author xom
 */
public class Dog extends Pet {

	protected String breed;
	
	/**
	 * @param age
	 * @param weight
	 */
	public Dog(int age, int weight, String breed) {
		super(age, weight);
		this.breed = breed;
	}

	@Override
	void makeSound() {
		System.out.println("bark, bay, growl, howl, yowl, whine, yip, yap, snap, snarl, whimper");

	}

	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}

}
