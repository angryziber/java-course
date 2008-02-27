package net.azib.java.students.t654321;

/**
 * Chicken
 *
 * @author karl
 */
public class Goose extends Animal{

	/**
	 * @param name
	 * @param color
	 * @param age
	 */
	public Goose(String name, String color, int age) {
		super(name, color, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	void fly() {
		System.out.println("Trying very hard");
	}

	@Override
	void jump() {
		System.out.println("I'm busy laying golden egg");
	}

	@Override
	void makeSound() {
		System.out.println("cacaaaa");
	}

	void eggLayer(){
		System.out.println("Laying a golden egg");
	}

}
