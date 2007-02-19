package net.azib.java.students.t030636.first;

/**
 * Dog
 *
 * @author t030636
 */
public class Dog extends Animal implements Comparable<Dog> {

	/**
	 * @param name
	 * @param age
	 */
	public Dog(String name, byte age) {
		super(name, age);
	}
	
	public String getName() {
		return "Dog: " + super.getName();
	}


	@Override
	public String toString() {
		return "I'm a Dog, and " + super.toString();
	}

	
	@Override
	public String getType() {
		return "Dog";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof Dog))
			return false;
		
		Dog otherDog = (Dog) other;
		return this.getName().equals(otherDog.getName());
	}

	@Override
	public int compareTo(Dog o) {
		return getName().compareTo(o.getName());
	}
}