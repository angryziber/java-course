package net.azib.java.students.t073639.taskAnimal;

/**
 * @author t073639
 * 
 */
public class Dog extends Pet {

	public Dog(int age, String name) {
		super(age, name);
	}

	@Override
	void makeSound() {
		System.out.println("Woof!");
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
}
