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
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		return "Dog " + name;
	}

}
