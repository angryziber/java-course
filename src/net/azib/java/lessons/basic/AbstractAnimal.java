package net.azib.java.lessons.basic;

/**
 * Abstract implementation of Animal interface to ease concrete implementations.
 *
 * @author anton
 */
public abstract class AbstractAnimal implements Animal {
	private String name;
	private byte age;

	public AbstractAnimal(String name) {
		this.name  = name;
	}

	public AbstractAnimal(String name, byte age) {
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
		return ((Byte)getAge()).compareTo(that.getAge());
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " named " + getName();
	}

	@Override
	public boolean equals(Object that) {
		if (that instanceof AbstractAnimal)
			return this.name.equals(((AbstractAnimal)that).name);
		else
			return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public Animal clone() {
		try {
			return (Animal) super.clone();
		}
		catch (CloneNotSupportedException e) {
			// this cannot happen
			throw new RuntimeException(e);
		}
	}
	
}
