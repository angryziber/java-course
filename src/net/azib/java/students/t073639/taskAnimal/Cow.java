package net.azib.java.students.t073639.taskAnimal;

/**
 * @author t073639
 * 
 */
public class Cow extends Animal {

	public Cow(int age) {
		super(age);
	}

	@Override
	void makeSound() {
		System.out.println("Mee...");
	}

	@Override
	public String toString() {
		return "Cow [age=" + age + "]";
	}

}
