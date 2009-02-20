package net.azib.java.students.t074918;

/**
 * Cat
 *
 * @author Mart Mangus
 */
public class Cat extends Animal {

	/**
	 * @param name
	 * @param age
	 */
	public Cat(String name, int age) {
		super(name, age);
	}

	@Override
	public void makeNoise() {
		System.out.println("mjäuuu!");
	}

}
