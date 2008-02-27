package net.azib.java.lessons.basic;

/**
 * Animal
 *
 * @author anton
 */
public abstract class Animal implements Comparable<Animal>, Cloneable {
	private String name;
	private byte age;

	public Animal(String name) {
		this.name  = name;
	}

	public Animal(String name, byte age) {
		this.name = name;
		this.age = age;
	}	

	public String getName() {
		return name;
	}
	
	public void growUp() {
		age++;
	}
	
	public byte getAge() {
		return age;
	}
	
	public abstract void makeSound();
	
	public int compareTo(Animal that) {
		return ((Byte)age).compareTo(that.age);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " named " + getName();
	}

	@Override
	public boolean equals(Object that) {
		if (that instanceof Animal)
			return this.name.equals(((Animal)that).name);
		else
			return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
