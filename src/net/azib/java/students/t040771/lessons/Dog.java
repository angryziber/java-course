package net.azib.java.students.t040771.lessons;

/**
 * Dog
 *
 * @author t040771
 */
public class Dog {

	protected String name;
	
	public Dog() {
		name = "Dog";
	}
	
	public Dog(String name) {
		this.name = name; //sinine name on field
	}
/**
 * @deprecated
 * @return
 */
	public String getName() {
		final String newName = name;
		return newName;
	}
	
	public String toString() {
		return "Dog " + name;
	}
}
