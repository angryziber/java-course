package net.azib.java.students.t011047;

/**
 * Dog
 *
 * @author t011047
 */
public class Dog extends Animal {

	/**
	 * @param name
	 */
	public Dog(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param age
	 */
	public Dog(String name, byte age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	public String getName()
	{
		return "Dog: " + super.getName();
	}

	@Override
	public String getType() {
		return "Dog";
	}
	
}
