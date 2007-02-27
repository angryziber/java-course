package net.azib.java.lessons.misc;

/**
 * Dog
 *
 * @author anton
 */
public class Dog extends Animal implements Comparable<Dog> {

	public Dog(String name) {
		super(name);
	}

	public Dog(String name, byte age) {
		super(name, age);
	}
	
	public String getName() {
		return "Dog: " + super.getName();
	}
	
	@Override
	public String getType() {
		return "Dog";
	}

	@Override
	public int compareTo(Dog o) {
		return getName().compareTo(o.getName());
	}
	
	
	
}
