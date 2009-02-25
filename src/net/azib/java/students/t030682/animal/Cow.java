package net.azib.java.students.t030682.animal;

/**
 * Cow
 *
 * @author Administrator
 */
public class Cow extends Animal {
	private float milk;
	public Cow(String name, int age, float milk) {
		super(name, age);
		this.milk = milk;
	}
	public void makeThing() {
		System.out.println("I have " + milk + " litres of milk");
	}
	
	@Override
	public void makeSound() {
		System.out.println("MMMMuuuuuuu!");
	}

}
