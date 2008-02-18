package net.azib.java.students.t040771.lessons;

/**
 * Bulldog
 *
 * @author t040771
 */
public class Bulldog extends Dog {
	/**
	 * @param string
	 */
	public Bulldog(String string) {
		super(string);
	}

	/** Default constructor
	 * 
	 */
	public Bulldog() {
		super();
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t040771.lessons.Dog#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Bulldog " + name;
	}
}
