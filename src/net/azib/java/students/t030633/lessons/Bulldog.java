package net.azib.java.students.t030633.lessons;

/**
 * Bulldog
 * 
 * @author t030633
 */
public class Bulldog extends Dog {

	Bulldog() {
	}

	Bulldog(String name) {
		super(name); // passes name to Dog
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.azib.java.students.t030633.lessons.Dog#toString()
	 */
	@Override
	public String toString() {
		return "Bulldog " + name;
	}

}
