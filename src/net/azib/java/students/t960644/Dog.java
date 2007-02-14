package net.azib.java.students.t960644;

/**
 * Dog
 *
 * @author t960644
 */
public class Dog extends Animal implements Comparable<Dog>{

	public Dog(String name) {
		super(name);
	}
	public Dog(String name, byte age) {
		super(name, age);
	}
	public String getName() {
		return "Dog: "+super.getName();
	}
/*	@Override
	public String toString() {
		return "I am Dog, "+super.toString();
	}*/
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Dog";
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Dog o) {
		// TODO Auto-generated method stub
		return getName().compareTo(o.getName());
	}
	
	
	
}
