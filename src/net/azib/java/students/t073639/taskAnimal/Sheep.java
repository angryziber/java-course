package net.azib.java.students.t073639.taskAnimal;

/**
 * @author t073639
 * 
 */
public class Sheep extends Animal {

	public Sheep(int age) {
		super(age);
	}

	@Override
	void makeSound() {
		System.out.println("Muuu...");
	}

	@Override
	public String toString() {
		return "Sheep [age=" + age + "]";
	}

}
