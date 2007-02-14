package net.azib.java.students.t030655.Lab2;

/**
 * Dog
 *
 * @author t030655
 */
public class Dog extends Animal {

	/**
	 * @param name
	 */
	public Dog(String name) {
		super(name);
	}

	public Dog(String name, byte age) {
		super(name, age);
	}
	
	public String getName(){
		return "Dog: " + super.getName();
	}
	
	@Override
	public String getType() {
		return "Dog";
	}

	
}
