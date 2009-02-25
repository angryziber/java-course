package net.azib.java.students.t030682.animal;

/**
 * Cat
 * 
 * @author Administrator
 */
public class Cat extends Animal {

	private float slept;

	public Cat(String name, int age, float slept) {
		super(name, age);
		this.slept = slept;
	}

	public void makeThing() {

		System.out.println("I have slept for " + slept + " hours");
	}

	@Override
	public void makeSound() {
		System.out.println("Muuuurrr!");
	}
}
