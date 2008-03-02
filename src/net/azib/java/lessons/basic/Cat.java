package net.azib.java.lessons.basic;

/**
 * Cat
 *
 * @author anton
 */
public class Cat extends AbstractAnimal {

	public Cat(String name) {
		super(name);
	}

	public Cat(String name, byte age) {
		super(name, age);
	}
	
	@Override
	public void makeSound() {
		System.out.println("Meow!");
	}
}
