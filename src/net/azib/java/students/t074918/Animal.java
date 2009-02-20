package net.azib.java.students.t074918;

import net.azib.java.students.t074918.Dog;

/**
 * Animal
 *
 * @author Mart Mangus
 */
public abstract class Animal {
	
	String name;
	private int age = 2;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Dog) {
			return (((Dog)obj).name.equals(this.name));
		}
		return false;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + name + " is " + age + " year(s) old.";
	}
	
	/**
	 * @Deprecated Please use {@link net.azib.java.students.t074918.Dog.toString}
	 * instead
	 */
	public String depFunction() {
		return "See ei ole hea funktsioon...";
	}
	
	public abstract void makeNoise();

}
