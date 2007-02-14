package net.azib.java.students.t060401;

/**
 * Dog
 *
 * @author t060401
 */
public class Dog extends Animal implements Comparable<Dog>{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * @param name
	 * @param age
	 */
	public Dog(String name, byte age) {
		super(name, age);
	}

	/**
	 * @param name
	 */
	public Dog(String name) {
		super(name);
	}

	public String getName() {
		return "Dog: " + super.getName();
	}

	@Override
	public String getType() {
		return "Dog";
	}

	@Override
	public int compareTo(Dog other) {
		return getName().compareTo(other.getName());
	}
	
}
