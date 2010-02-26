package net.azib.java.students.t050724.animals;

/**
 * Animal
 *
 * @author xom
 */
public abstract class Animal {

	protected int age;
	protected int weight;
	
	abstract void makeSound();

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @param age
	 * @param weight
	 */
	public Animal(int age, int weight) {
		this.age = age;
		this.weight = weight;
	}
	
	
	
}
