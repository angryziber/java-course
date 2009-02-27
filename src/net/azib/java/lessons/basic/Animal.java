package net.azib.java.lessons.basic;

/**
 * Animal
 *
 * @author anton
 */
public abstract class Animal implements Cloneable {
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
	public Animal clone() throws CloneNotSupportedException {
		Animal clone = (Animal) super.clone();
		clone.age = 0;
		return clone;
	}
}
