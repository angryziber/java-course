package net.azib.java.students.t030630;

import java.io.Serializable;

/**
 * Animal
 * 
 * @author Kasutaja
 */
public abstract class Animal implements Serializable {
	private String name;
	private byte age;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public Animal(String name, byte age) {
		super();
		this.name = name;
		this.age = age;
	}

	/**
	 * @param name
	 */
	public Animal(String name) {
		super();
		this.name = name;
	}

	public void growUp() {
		age++;
	};

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public byte getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(byte age) {
		this.age = age;
	}

	public abstract String getType();

	@Override
	public final String toString() {
		return "I am " + getType() + ". My name is " + this.getName() + ". I am " + this.getAge() + " age old";
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof Dog))
			return false;
		return this.getName().equals(((Animal) other).getName()) && this.getClass() == other.getClass();

	}

	@Override
	public int hashCode() {
		return getName().hashCode()+ getClass().hashCode();
	}
}
