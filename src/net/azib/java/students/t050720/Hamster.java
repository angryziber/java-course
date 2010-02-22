package net.azib.java.students.t050720;

/**
 * Hamster
 *
 * @author Marek
 */
public class Hamster extends Pet {

	int numOfSeedsCarriable;
	
	/**
	 * Every hamster can carry a number of seeds in its mouth.
	 * @return the number of seeds this hamster can carry.
	 */
	public int getNumOfSeedsCarriable() {
		return numOfSeedsCarriable;
	}

	/**
	 * @param numOfSeedsCarried the numOfSeedsCarried to set
	 */
	public void setNumOfSeedsCarriable(int numOfSeedsCarried) {
		this.numOfSeedsCarriable = numOfSeedsCarried;
	}

	void makeSound() {
		System.out.println("squeak!");
	}

	public String toString()
	{
		return new String("Hi! I'm a hamster!");
	}

}
