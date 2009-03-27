package net.azib.java.lessons.basic;

import java.io.Serializable;

/**
 * Animal
 *
 * @author anton
 */
@Todo("implement toString")
public abstract class Animal implements Cloneable, Serializable, Comparable<Animal> {
	String name;
	private int age;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return getClass().getSimpleName() + " named " + name + " and aged " + age;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Animal) {
			Animal that = (Animal)o;
			return that.name.equals(this.name) 
				&& that.age == this.age;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + age * 37;
	}

	public abstract void makeNoise();

	@Override
	public Animal clone() {
		try {
			Animal clone = (Animal) super.clone();
			clone.age = 0;
			return clone;
		}
		catch (CloneNotSupportedException e) {
			// never should happen - Animal implements Cloneable
			System.err.println("Clone failed:" + e);
			return null;
		}
	}

	public int compareTo(Animal a) {
		return a.age - this.age;
	}
}
