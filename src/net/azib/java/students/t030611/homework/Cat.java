package net.azib.java.students.t030611.homework;

/**
 * Cat
 * 
 * @author Jekaterina
 */
public class Cat extends Animal {
	private String breed;

	/** @Override */
	String getVoice() {
		return "mjau!";
	}

	Cat(String name, String breed, int age) {
		super(name,age);
		this.breed = breed;
	}

	/** returns cat's breed */
	String getBreed() {
		final String newBreed = breed;
		return newBreed;
	}

	/** @Override */
	public String toString() {
		return "My " +getClass().getName()+ ": breed: " + getBreed() + ", name: " + getName() + ", age" + getAge()+", says " + getVoice();
	}
}
