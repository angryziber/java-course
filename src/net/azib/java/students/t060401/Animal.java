package net.azib.java.students.t060401;

import java.io.Serializable;

/**
 * Dog
 *
 * @author t060401
 */
public abstract class Animal implements Serializable {
	
	private String name;
	private byte age;

	public String getName() {
		return name;
	}
	
	public void growUp() {
		age++;
	}
	
	public byte getAge() {
		return age;
	}
	
	public Animal(String name) {
		this.name  = name;
	}

	public Animal(String name, byte age) {
		this.name = name;
		this.age = age;
	}

	public abstract String getType();
	
	@Override
	public final String toString() {
		return "I am "+getType()+". My name is "+name+" and I am "+age+" years old.";
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof Animal))
			return false;
				
		return this.getName().equals(((Animal)other).getName()) && this.getClass() == other.getClass();
	}
	
	@Override
	public int hashCode() {
		return getName().hashCode() + getClass().hashCode();
	}
	
}
