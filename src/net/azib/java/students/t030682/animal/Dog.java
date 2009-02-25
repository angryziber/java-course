package net.azib.java.students.t030682.animal;

/**
 * Dog
 * 
 * @author Administrator
 */
public class Dog extends Animal {
	private float meat;

	public Dog(String name, int age, float meat) {
		super(name, age);
		this.meat = meat;
	}

	public void makeThing() {
		System.out.println("I have eaten " + meat + " kg of meat");

	}

	@Override
	public void makeSound() {
		System.out.println("Gav-Gav!");
	}

}
