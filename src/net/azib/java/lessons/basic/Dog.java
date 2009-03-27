package net.azib.java.lessons.basic;

/**
 * Dog
 *
 * @author anton
 */
public class Dog extends Animal {
	private static final long serialVersionUID = 1;
	
	public Dog(String name, int age) {
		super(name, age);
	}

	@Override
	public void makeNoise() {
		System.out.println("Woof!");
	}
}
