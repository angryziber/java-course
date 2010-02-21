package net.azib.java.students.t073639.taskAnimal;

/**
 * @author t073639
 * 
 */
public class Cat extends Pet {

	public Cat(int age, String name) {
		super(age, name);
	}

	@Override
	void makeSound() {
		System.out.println("Miau...");
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age  + "]";
	}

}
