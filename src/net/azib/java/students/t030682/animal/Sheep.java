package net.azib.java.students.t030682.animal;

/**
 * Sheep
 *
 * @author Administrator
 */
public class Sheep extends Animal {
	private float weight;
	public Sheep(String name, int age, float weight) {
		super(name, age);
		this.weight = weight;
	}

	public void makeThing() {
		System.out.println("My weight is " + weight + " kg");
	}
	
	@Override
	public void makeSound() {
		System.out.println("Beeee!");

	}

}
