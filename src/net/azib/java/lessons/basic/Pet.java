package net.azib.java.lessons.basic;

import net.azib.java.lessons.exception.PetNameException;

import java.io.Serializable;

/**
 * Pet
 *
 * @author anton
 */
public abstract class Pet implements Cloneable, Serializable {
	private String name;
	private int age;
	
	/**
	 * @param name
	 * @param age
	 * @throws PetNameException thrown if name is not specified
	 */
	public Pet(String name, int age) {		
		try {
			name.toString();
		}
		catch (NullPointerException e) {
			throw new PetNameException(e);
		}
		
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	public abstract String getSound();
	
	@Override
	public Pet clone() throws CloneNotSupportedException {
		return (Pet)super.clone();
	}	
}
