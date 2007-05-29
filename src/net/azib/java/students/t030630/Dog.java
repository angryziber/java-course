package net.azib.java.students.t030630;

/**
 * Dog
 * 
 * @author t030630
 */
public class Dog extends Animal implements Comparable<Animal>, IAnimal {

	/**
	 * @param name
	 */
	public Dog(String name) {
		super(name);
	}

	public Dog(String name, byte age) {
		super(name, age);
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t030630.IAnimal#getName()
	 */
	public String getName() {
		return super.getName();
	}

	// @Override
	// public String toString() {
	// return super.toString();
	// }

	/* (non-Javadoc)
	 * @see net.azib.java.students.t030630.IAnimal#getType()
	 */
	@Override
	public String getType() {
		return "a dog";
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Animal o) {
		// TODO Auto-generated method stub
		return getName().compareTo(o.getName());
	}
}
