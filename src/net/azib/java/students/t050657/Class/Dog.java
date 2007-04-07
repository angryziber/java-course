package net.azib.java.students.t050657.Class;

/**
 * Dog
 *
 * @author t050657
 */
public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}

	public Dog(String name, int age) {
		super(name, age);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t050657.Animal#toString()
	 */
	@Override
	public String getType() {
		return "Dog";
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == null || !(other instanceof Dog))
			return false;
		Dog dog = (Dog) other;
		return this.getName() == dog.getName();
	}
}
