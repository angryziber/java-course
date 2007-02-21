package net.azib.java.students.t030632;

/**
 * Dog
 *
 * @author Toni
 */
public class Dog extends Animal implements Comparable <Dog>{

	/**
	 * @param name
	 */
	public Dog(String name) {
		super(name);
	}

	/**
	 * @param name
	 * @param age
	 */
	public Dog(String name, byte age) {
		super(name, age);
	}
	public String getName(){
		return "Dog: "+super.getName();
	}

	
	//@Override
	/*public String toString() {
		// TODO Auto-generated method stub
		return "I am Dog, "+super.toString();
	}*/

	
	@Override
	//final is made to restrict overriding of this method
	public final String getType() {
		return "Dog";
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Dog d ) {
		// TODO Auto-generated method stub
		return getName().compareTo(d.getName());
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t030632.Animal#equals(java.lang.Object)
	 */
	
	
	
}
