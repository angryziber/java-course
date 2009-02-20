package net.azib.java.lessons.basic;

/**
 * Animal
 *
 * @author anton
 */
public abstract class Animal {
	String name;
	private int age;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return getClass().getSimpleName() + " named " + name + " and aged " + age;
	}

	public boolean equals(Object that) {
		if (that instanceof Dog) {
			Dog thatDog = (Dog)that;
			return thatDog.name.equals(this.name);
		}
		return false;
	}
	
	public abstract void makeNoise();
}
