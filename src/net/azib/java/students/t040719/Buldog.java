package net.azib.java.students.t040719;

/**
 * Buldog
 *
 * @author t040719
 */
public class Buldog extends Dog {

	/**
	 * @param name
	 */
	public Buldog(String name) {
		super(name);
		this.name = "Buldog " + name;
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bulldog: " + getName();
	}
	
	
}
