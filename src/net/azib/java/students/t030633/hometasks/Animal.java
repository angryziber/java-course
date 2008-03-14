package net.azib.java.students.t030633.hometasks;

/**
 * Abstract animal.
 * 
 * @author t030633
 */

abstract public class Animal implements Comparable<Animal>, Cloneable {

	protected String name;
	protected Integer age;

	Animal() {
		name = "Noname";
	}

	Animal(String setname, int setage) {
		name = setname;
		age = setage;
	}

	public int compareTo(Animal that) {
		// age is a primitive type
		// to make auto-boxing work we have to wrap age
		// into an object
		return new Integer(age).compareTo((int) that.age);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object that) {
		if (that instanceof Animal)
			return this.name.equals(((Animal) that).name);
		else
			return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	public int getAge() {
		return age;
	}

	protected String getName() {
		return getClass().getSimpleName() + ' ' + name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	protected abstract String makeSound();

	public String toString() {
		return getName() + " says " + makeSound();
	}

}
