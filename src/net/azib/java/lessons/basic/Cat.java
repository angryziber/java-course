package net.azib.java.lessons.basic;

/**
 * Cat
 *
 * @author anton
 */
public class Cat extends Pet {

	/**
	 * @param name
	 * @param age
	 */
	public Cat(String name, int age) {
		super(name, age);
	}

	@Override
	public String getSound() {
		return "Meow";
	}
}
