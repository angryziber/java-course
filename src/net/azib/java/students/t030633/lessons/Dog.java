package net.azib.java.students.t030633.lessons;

/**
 * Dog
 * 
 * @author t030633
 */
public class Dog {

	protected String name;

	Dog() {
		this.name = "Noname";
	}

	Dog(String name) {
		this.name = name;
	}

	// public String getName() {
	// String newName = "Mega " + name;
	// return newName;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dog " + name;
	}

}
